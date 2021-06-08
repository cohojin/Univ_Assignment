package highJavaProgramming3;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ForkJoinDirSize extends RecursiveTask<Long> {
	private final Path path;
	
	public ForkJoinDirSize(Path path) {
		this.path=path;
	}
	@Override
	protected Long compute() {
		long fileSize=0;
		
		//디렉토리일 경우 하위 작업으로 분리한다. 
		if(Files.isDirectory(path)) {
			try {
				List<Path> fileList =Files.list(path).collect(Collectors.toList());
				List<ForkJoinDirSize> subTaskList = new ArrayList<>();
				
				//하위 작업을 생성하고 포크시킨다. (백그라운드로 실행시킨다.) 
				for (Path file : fileList) {
					ForkJoinDirSize subTask = new ForkJoinDirSize(file);
					subTask.fork();
					//작업 목록을 관리하기 위해 List 객체에 추가한다. 
					subTaskList.add(subTask);
				}
				Long subSize = 0L;
				
				//하위 작업들이 종료될 때까지 대기한다. 
				for(ForkJoinDirSize subTask : subTaskList) {
					subSize +=subTask.join();
				}
				return subSize;
			}
			catch(IOException e) {
				System.out.println("Error : "+path);
			}
		}
		//파일일 경우 크기 리턴 
		else {
			try {
				fileSize = Files.size(path);
			}
			catch(IOException e) {
				System.out.println("Error : "+path);
			}
		}
		return fileSize;
	}
	public static void main(String[] args) {
		Path rootPath = Paths.get("C:\\Program Files\\Git");
		//포크 조인 스레드 풀 생성 
		ForkJoinPool pool = new ForkJoinPool();
		System.out.printf("병렬 처리 크기 : %s \n" , pool.getParallelism());
		System.out.printf("합계:%s \n",pool.invoke(new ForkJoinDirSize(rootPath)));
		
	}

}
