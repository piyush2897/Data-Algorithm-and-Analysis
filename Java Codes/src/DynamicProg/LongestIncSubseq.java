package DynamicProg;

import java.util.Scanner;

public class LongestIncSubseq {
	
	static int LIS(int arr[],int n) {
		
		return 0;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			System.out.println(LIS(arr,n));
		}
		sc.close();
	}
}
