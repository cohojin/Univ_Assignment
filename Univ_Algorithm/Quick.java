package hw4_1;

import java.util.Arrays;
import java.util.Scanner;


public class Quick {
	// p는 배열에 맨 처음 위치 r은 배열에 맨 끝 위치 파티션을 이용해 pivot값 q를 설정  
	
	static int q;
	
	public static String quickSort(String word[],int p,int r) {
		if(p<r) {
			q=partition(word,p,r);
			quickSort(word,p,q-1);
			quickSort(word,q+1,r);
		}
		return Arrays.toString(word);
	}
	
	public static int partition(String word[],int p,int r) {
		/*
		가장 뒤에 있는 값을 기준값을 설정하고 기준값보다 작은수들을 배열에서 골라서 
		앞에 위치시키고 기준을 두고 나머지는 뒤에 둔다. 그리고 quickSort()를 통해서 앞과 뒤를 따로 정렬해준다. 
		*/
		
		int j; //word[]에서 첫번째 원소 j
		
		String temp; //임시로 값 저장
		
		String x=word[r]; //pivot word[]에서 마지막 원소
		int i=p-1;
		for(j=0;j<=r-1;j++) {
			
			//result가 0이면 동일 1이면 r이큰거 -1이면 j가 큰거
			int result=word[r].compareToIgnoreCase(word[j]);
			switch(result){ 
			case 0:
				break;
			case 1:
				i++;
				temp=word[i]; 
				word[i]=word[j]; 
				word[j]=temp; 
				break;
			case -1:
				break;
			}
			
		}
		//마지막 정리된 값을 바꿔준다.
		temp=word[i+1];
		word[i+1]=word[r];
		word[r]=temp;
		
		return i+1;
	}
	
	
	public static void main(String[] args) {
		int i;
		
		System.out.println("hw4_1:김호진");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("단어 수 입력:");
		int num=sc.nextInt(); //단어수를 입력 
		
		String word[] =new String[num];
		
		//n개의 단어를 비교한다. 
		System.out.print(num+"개의 단어 입력:");
		for(i=0;i<num;i++) {
			word[i]=sc.next(); //공백을 기준으로 문자들을 구분한다.
		}
		
		System.out.print("퀵 정렬 결과:"+quickSort(word,0,num-1));
		sc.close();
		
	}

}
