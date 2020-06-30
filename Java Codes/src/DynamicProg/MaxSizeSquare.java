package DynamicProg;

import java.util.Scanner;

public class MaxSizeSquare {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-->0) {
			
			int m = sc.nextInt();
			int n = sc.nextInt();
			int arr[][] = new int[m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int s[][] = new int[m][n];
			int max=1;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(i==0||j==0)
						s[i][j]=arr[i][j];
					else if(arr[i][j]==0)
						s[i][j]=0;
					else
						s[i][j] = Math.min(s[i][j-1], Math.min(s[i-1][j], s[i-1][j-1])) + 1; 
					
					if(s[i][j]>max)
						max=s[i][j];
					
				}
			}
			
			System.out.println(max);
		}
		sc.close();
	}
}
