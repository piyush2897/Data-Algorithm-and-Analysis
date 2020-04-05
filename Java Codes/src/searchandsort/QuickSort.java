package searchandsort;

import java.util.Scanner;

public class QuickSort {
	
	static void swap(int arr[],int a,int b) {
		
		int t =arr[a];
		arr[a]=arr[b];
		arr[b]=t;
		
	}
	
	static int partition(int arr[],int s,int e) {
		
		int pivot = e;
		int a=s,b=s;
		
		while(a<pivot) {
			if(arr[a] < arr[pivot]) {
				swap(arr,a,b);
				a++;
				b++;
			}else {
				a++;
			}
		}
		
		swap(arr,pivot,b);
		
		return b;
	}
	
	static void Sort(int arr[],int s,int e) {
		
		if(s<e) {
			
			int p = partition(arr,s,e);
			Sort(arr,s,p-1);
			Sort(arr,p+1,e);
			
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		Sort(arr,0,n-1);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		sc.close();
		
	}

}
