package DynamicProg;

import java.util.Scanner;

class vari{
	char c = 'A';
}

public class MatrixMul {
	
	static void printString(int s[][],vari ch,int i,int j) {
		if(i == j) {
			System.out.print(ch.c);
			ch.c = (char)(ch.c+1);
		}
		else {
			System.out.print("(");
			printString(s,ch,i,s[i][j]);
			printString(s,ch,s[i][j]+1,j);
			System.out.print(")");
		}
	}
	
	static int MatrixFun(int arr[],int n) {
		int mat[][] = new int[n][n];
		int s[][] = new int[n][n];
		for(int i=1;i<n;i++)
			mat[i][i]=0;
		for(int l=2;l<n;l++) {
			for(int i=1;i<n-l+1;i++) {
				int j=i+l-1;
				int min = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					mat[i][j] = mat[i][k] + mat[k+1][j] + arr[i-1]*arr[k]*arr[j];
					if(mat[i][j] < min) {
						min = mat[i][j];
						s[i][j] = k;
					}	
				}
				mat[i][j]=min;
			}
		}
		printString(s,new vari(),1,n-1);
		return mat[1][n-1];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			int val = MatrixFun(arr,n);
			System.out.println(val);
		}
		sc.close();
	}
}
