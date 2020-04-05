package searchandsort;

import java.util.Scanner;

public class CycleSort {
	
	static void swap(int arr[],int a,int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	static void Sort(int arr[] ,int n) {
		
		for(int i=0;i<n-1;i++) {
			
			int count =0;
			
			for(int j=i+1;j<n;j++) {
				if(arr[j] < arr[i])
					count++;
			}
				
			while(count !=0) {
				
				swap(arr,i,i+count);
				
				count=0;
				for(int j=i+1;j<n;j++) {
					if(arr[j] < arr[i])
						count++;
				}
			}
			
		}
	}
	
	public static void main() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		Sort(arr,n);
		sc.close();
	}

}
