package searchandsort;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NearlySortedArray {
	
	static void sort(int arr[],int n,int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<=k;i++)
			pq.add(arr[i]);
		int index=0;
		for(int i=k+1;i<n;i++) {
			arr[index++] = pq.peek();
			pq.poll();
			pq.add(arr[i]);
		}
		Iterator<Integer> itr = pq.iterator();
		while(itr.hasNext()) {
			arr[index++] = pq.peek();
			pq.poll();
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		sort(arr,n,k);
		for(int i=0;i<n;i++)
			System.out.print(arr[i] +" ");
		sc.close();
	}

}
