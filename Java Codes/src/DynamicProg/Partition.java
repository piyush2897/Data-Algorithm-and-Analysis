package DynamicProg;

import java.util.Scanner;

public class Partition {
	
	static int findPart(int arr[]) {
		
		int sum=0;
		int n =arr.length;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		
		if(sum%2!=0) return 0;
		boolean val[] = new boolean[sum/2+1];
		val[0]=true;
		for(int i=0;i<n;i++) {
			val[arr[i]]=true;
		}
		for(int i=1;i<sum/2;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]<=i) {
					val[i] = val[i] || val[i-arr[j]];
				}
			}
		}
		
		if(val[sum/2] == true)
			return 1;
		return 0;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			int val = findPart(arr);
			System.out.println(val);
		}
		sc.close();
	}
}
