package searchandsort;

import java.util.Scanner;

public class QuickSort_Iterative {
	
	static void swap(int arr[],int a,int b) {
		
		int t =arr[a];
		arr[a]=arr[b];
		arr[b]=t;
		
	}
	
	static int partition(int arr[],int s,int e) {
		
		if(s == e )
			return s;
		
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
	
	static void  QuickSort(int arr[], int s,int e) {
		
		int[] stack = new int[1000];
		int top = -1;
		
		stack[++top] = s;
		stack[++top] = e;
		
		while(top >= 0) {
			
			int h = stack[top--];
			int l = stack[top--];
			
			int p = partition(arr,l,h);
			
			if(p-1 >= l) {
				stack[++top] = l;
				stack[++top] = p-1;
 			}
			
			
			if(p+1 <= h) {
				stack[++top] = p+1;
				stack[++top] = h;
			}
			
		}
		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		QuickSort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		sc.close();
	}
	
}
