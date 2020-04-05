package searchandsort;

import java.util.Scanner;

public class EffectiveSort {
	
	static void countsort(int arr[],int n, int exp) {
		
		int[] output = new int[n];
		int[] count = new int[n];
		
		for(int i=0;i<n;i++)
			count[i]=0;
		
		for(int i=0;i<n;i++)
			count[(arr[i]/exp)%n]++;
		
		for(int i=1;i<n;i++)
			count[i] += count[i-1];
		
		for (int i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%n] - 1] = arr[i]; 
            count[(arr[i]/exp)%n]--; 
        } 
		
		for(int i=0;i<n;i++)
			arr[i] = output[i];
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			countsort(arr,n,1);
			countsort(arr,n,n);
			for(int i=0;i<n;i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		sc.close();
	}

}
