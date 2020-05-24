package DynamicProg;

import java.util.Scanner;

public class WordWrap {
	
	static void wordWrap(int val[],int n,int m) {
		int es[][] = new int[n][n];
		int dp[][] = new int[n][n];
		int cost[] = new int[n];
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(i==j) es[i][j] = m-val[i];
				else {
					es[i][j] = es[i][j-1] - (val[j]+1);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(es[i][j]>=0) 
					dp[i][j] = es[i][j]*es[i][j];
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		cost[0]=dp[0][0];
		for(int i=1;i<n;i++) {
			if(dp[0][i]!=Integer.MAX_VALUE) cost[i]=dp[0][i];
			else {
				cost[i]=Integer.MAX_VALUE;
				for(int j=0;j<i;j++) {
					if(dp[j+1][i]!=Integer.MAX_VALUE && cost[j]!=Integer.MAX_VALUE && cost[j] + dp[j+1][i] < cost[i]) {
						cost[i] = cost[j] + dp[j+1][i];
					}
				}
			}
		}
		
		System.out.println(cost[n-1]);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int k = sc.nextInt();
			wordWrap(arr,n,k);
		}
		sc.close();
	}
}
