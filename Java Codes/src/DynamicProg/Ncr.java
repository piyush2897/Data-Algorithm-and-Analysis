package DynamicProg;

import java.util.Scanner;

public class Ncr {
	
	static int ncr(int n,int r) {
		int mod = 1000000007;
		int arr[][] = new int[n+1][r+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=r;j++) {
				if(j>i) {
					break;
				}else if(i==j || i==0 || j==0) {
					arr[i][j]=1;
				}else {
					arr[i][j] = (arr[i-1][j]%mod + arr[i-1][j-1]%mod)%mod;
				}
			}
		}
		return arr[n][r];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(ncr(n,r));
		}
		sc.close();
	}
}
