package hw9_1;

import java.util.*;

public class DynamicProgramming {
	
	public static int LCS(String firstWord ,String secondWord) {
		int m,n; //행 m 열 n
		
		m=firstWord.length();
		n=secondWord.length();
		
		//2차원 배열
		int C[][] =new int[m+1][n+1];
		
		
		int i=0,j=0;
		//제일 밖을 0으로 초기화 
		for(i=0;i<=m;i++) {
			C[i][0]=0;
		}
		for(j=0;j<=n;j++) {
			C[0][j]=0;
		}
		for(i=1;i<=m;i++) {
			for(j=1;j<=n;j++) {
				if(firstWord.charAt(i-1)==secondWord.charAt(j-1)) {
					C[i][j] = C[i-1][j-1]+1;
				}else {
					C[i][j] =Math.max(C[i-1][j],C[i][j-1]);
				}
			}
		}
		
		return C[m][n];
	}

	public static void main(String[] args) {
		
		String firstWord;
		String secondWord;
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("hw9_1:김호진");
		System.out.print("첫번째 문자열 입력:");
		firstWord = sc.nextLine(); 
		
		System.out.print("두번째 문자열 입력:");
		secondWord = sc.nextLine();
		
		System.out.println("LCS의 길이 = "+LCS(firstWord,secondWord));

	}

}
