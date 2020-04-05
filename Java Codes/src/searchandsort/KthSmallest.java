package searchandsort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallest {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int k = sc.nextInt();
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer a,Integer b) {
					return b.compareTo(a);
				}
			});
			
			for(int i=0;i<k;i++) pq.add(arr[i]);
			
			for(int i=k;i<n;i++) {
				if(pq.peek() > arr[i]) {
					pq.poll();
					pq.add(arr[i]);
				}
			}
			
			System.out.println(pq.peek());
			
		}
		sc.close();
	}

}
