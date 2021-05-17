package hw9_1;

import java.util.*;

public class DynamicProgramming {
	
	public static int LCS(String firstWord ,String secondWord) {
		int m,n; //�� m �� n
		
		m=firstWord.length();
		n=secondWord.length();
		
		//2���� �迭
		int C[][] =new int[m+1][n+1];
		
		
		int i=0,j=0;
		//���� ���� 0���� �ʱ�ȭ 
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
		
		System.out.println("hw9_1:��ȣ��");
		System.out.print("ù��° ���ڿ� �Է�:");
		firstWord = sc.nextLine(); 
		
		System.out.print("�ι�° ���ڿ� �Է�:");
		secondWord = sc.nextLine();
		
		System.out.println("LCS�� ���� = "+LCS(firstWord,secondWord));

	}

}
