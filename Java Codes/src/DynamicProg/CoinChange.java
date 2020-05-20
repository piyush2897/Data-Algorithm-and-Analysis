package DynamicProg;

import java.util.Scanner;

public class CoinChange {
	
	static int coinCount(int coins[], int n, int k) {
		int arr[] = new int[k+1];
		for(int i=1;i<k+1;i++)
			arr[i]=0;
		arr[0]=1;
		for(int j=0;j<n;j++) {
			for(int i=1;i<=k;i++) {
				if(i-coins[j] >=0 ) {
					arr[i] += arr[i-coins[j]];
				}
			}
		}
		return arr[k];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int coins[] = new int[n];
			for(int i=0;i<n;i++)
				coins[i] = sc.nextInt();
			int k=sc.nextInt();
			System.out.println(coinCount(coins,n,k));
		}
		sc.close();
	}
}
