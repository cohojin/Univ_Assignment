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
		
		//���丮�� ��� ���� �۾����� �и��Ѵ�. 
		if(Files.isDirectory(path)) {
			try {
				List<Path> fileList =Files.list(path).collect(Collectors.toList());
				List<ForkJoinDirSize> subTaskList = new ArrayList<>();
				
				//���� �۾��� �����ϰ� ��ũ��Ų��. (��׶���� �����Ų��.) 
				for (Path file : fileList) {
					ForkJoinDirSize subTask = new ForkJoinDirSize(file);
					subTask.fork();
					//�۾� ����� �����ϱ� ���� List ��ü�� �߰��Ѵ�. 
					subTaskList.add(subTask);
				}
				Long subSize = 0L;
				
				//���� �۾����� ����� ������ ����Ѵ�. 
				for(ForkJoinDirSize subTask : subTaskList) {
					subSize +=subTask.join();
				}
				return subSize;
			}
			catch(IOException e) {
				System.out.println("Error : "+path);
			}
		}
		//������ ��� ũ�� ���� 
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
		//��ũ ���� ������ Ǯ ���� 
		ForkJoinPool pool = new ForkJoinPool();
		System.out.printf("���� ó�� ũ�� : %s \n" , pool.getParallelism());
		System.out.printf("�հ�:%s \n",pool.invoke(new ForkJoinDirSize(rootPath)));
		
	}

}
