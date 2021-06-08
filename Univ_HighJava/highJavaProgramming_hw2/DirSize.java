import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirSize {
	//��� ȣ��Ǵ� �޼��� 
	protected Long compute(Path path) {
		long fileSize=0;
		
		try {
			List<Path> fileList = Files.list(path).collect(Collectors.toList());
			
			for(Path file : fileList) {
				if(Files.isDirectory(file)) {
					fileSize +=compute(file);
				}
				else {
					fileSize +=Files.size(file);
				}
			}
		}
		catch(IOException e) {
			System.out.println("Error : "+path);
		}
		return fileSize;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		Path rootPath = Paths.get("C:\\Program Files\\Git");
		
		DirSize dirSize =new DirSize();
		System.out.printf("�հ� : %s \n",dirSize.compute(rootPath));
		
		long endTime = System.currentTimeMillis();
		
		System.out.printf("ó�� �ð�: %s ",+(endTime-startTime));
		
	}

}
