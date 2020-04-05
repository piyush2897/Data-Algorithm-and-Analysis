package searchandsort;

import java.util.Scanner;

public class MergeSort {
	
	static void merge(int arr[] ,int s ,int mid ,int e) {
		
		
		int x[] = new int[mid-s];
		int y[] = new int[e-mid+1];
		
		for(int i = 0;i<mid-s;i++)
			x[i]=arr[i+s];
		for(int i = 0;i<e-mid+1;i++)
			y[i]=arr[i+mid];
		
		
		int a=0,b=0;
		
		for(int i=s;i<=e;i++) {
		
			if(a<mid-s && b<e-mid+1) {
				if(x[a] < y[b]) {
					arr[i]=x[a];
					a++;
				}else {
					arr[i]=y[b];
					b++;
				}
			}else if(a<mid-s) {
				arr[i]=x[a];
				a++;
			}else {
				arr[i]=y[b];
				b++;
			}		
		}
		
	}
	
	static void mergeSort(int arr[],int s ,int e) {
		
		if(s < e && s >= 0 && e>=0) {
			
			int mid = (s+e+1)/2;
			
			mergeSort(arr,s,mid-1);
			mergeSort(arr,mid,e);
			merge(arr,s,mid,e);
		}
		
	}
	
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[]  = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr,0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}

}



