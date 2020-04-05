package searchandsort;

import java.util.Scanner;

public class LengthUnsortedSubarray {
	
	static int s=0,e=0;
	
	static void SubarrayFun(int arr[],int n) {
		
		int i;
		
		for(i=0;i<n-1;i++)
			if(arr[i+1] < arr[i])
				break;
		
		s=i;
		
		for(i=n-1;i>0;i--)
			if(arr[i-1] > arr[i])
				break;
		
		e=i;
		
		if(s == e)
			return;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(i=s;i<=e;i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		//System.out.println(min + ":" +max);
		
		if(min == max )
			return;
		
		for(i=s-1;i>=0;i--) {
			if(arr[i] > min) {
				s=i;
			}
		}
		
		for(i=e+1;i<n;i++) {
			if(arr[i] < max) {
				e=i;
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			
			int k = sc.nextInt();
			int[] arr = new int[k];
			for(int j=0;j<k;j++)
				arr[j] = sc.nextInt();
			
			SubarrayFun(arr,k);
			System.out.println(s + " " + e);
		}
		
		sc.close();
	}

}
