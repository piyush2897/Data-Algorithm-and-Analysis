package DynamicProg;

import java.util.Scanner;

public class MinimumCostPath {
	
	static int max(int a,int b,int c) {
		if(a>b && a>c)
			return a;
		else if(b>a && b>c)
			return b;
		return c;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0 ) {
			int n = sc.nextInt();
			int cp[][] = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					cp[i][j] = sc.nextInt();
				}
			}
			int arr[][] = new int[n+1][n+2];
			for(int i=0;i<n+1;i++) {
				arr[0][i] = Integer.MIN_VALUE;
				arr[i][0] = Integer.MIN_VALUE;
				arr[i][n+1] =  Integer.MIN_VALUE;
			}
			arr[0][0]=0;
			for(int i=1;i<n+1;i++)
				arr[1][i] = cp[0][i-1];
			for(int i=2;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					arr[i][j] = max(arr[i-1][j-1] ,arr[i-1][j] ,arr[i-1][j+1]) + cp[i-1][j-1];
				}
			}
			
			int m=0;
			for(int i=1;i<n+1;i++)
				if(arr[n][i] > m)
					m=arr[n][i];
			
			System.out.println(m);
		}
		sc.close();
	}
}
