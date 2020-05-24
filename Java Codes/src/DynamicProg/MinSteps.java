package DynamicProg;

import java.util.Scanner;

public class MinSteps {
	
	static int steps(int arr[],int n) {
		int s[] = new int[n];
		s[0]=0;
		for(int i=1;i<n;i++) {
			s[i]=Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				if(i-j <= arr[j] && s[i]>s[j]+1) {
					s[i]=s[j]+1;
				}
			}
		}
		return s[n-1];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int x = steps(arr,n);
			if(x>=0 && x!=Integer.MAX_VALUE)
				System.out.println(x);
			else
				System.out.println(-1);
		}
		sc.close();
	}
}
