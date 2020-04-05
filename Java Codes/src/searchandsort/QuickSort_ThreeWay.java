package searchandsort;

import java.util.Scanner;

class Temp{
	int value;
	Temp(int k){
		value = k;
	}
}

public class QuickSort_ThreeWay {
	
	static void swap(int arr[],int a,int b) {
		
		int t =arr[a];
		arr[a]=arr[b];
		arr[b]=t;
		
	}
	
	static void partition(int arr[],int s,int e,Temp i,Temp j) {
		
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
		
		i.value = b-1;
		int val = arr[b];
		b++;
		int c=b;
		
		while(c<=e) {
			if(arr[c] == val) {
				swap(arr,b,c);
				c++;
				b++;
			}else {
				c++;
			}
		}
		
		j.value=b+1;
		
	}
	
	static void QuickSort(int arr[] , int s ,int e) {
		
		if(s<e) {
			
			Temp i = new Temp(0);
			Temp j = new Temp(0);
			
			partition(arr,s,e,i,j);
			QuickSort(arr,s,i.value);
			QuickSort(arr, j.value, e);
			
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		QuickSort(arr,0,n-1);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		sc.close();
		
	}

}
