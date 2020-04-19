package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class TNode {
	int time;
	int ad;
}

class tcomp implements Comparator<TNode>{
	public int compare(TNode a, TNode b) {
		return a.time-b.time;
	}
}

public class Train {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			TNode[] arr = new TNode[2*n];
			for(int i=0;i<2*n;i++)
				arr[i] = new TNode();
			for(int i=0;i<n;i++) {
				arr[i].time = sc.nextInt();
				arr[i].ad=0;
			}
			for(int i=n;i<2*n;i++) {
				arr[i].time = sc.nextInt();
				arr[i].ad=1;
			}
			Arrays.sort(arr, new tcomp());
			int max=0;
			int count=0;
			for(int i=0;i<2*n;i++) {
				if(arr[i].ad == 0)
					count++;
				if(arr[i].ad == 1)
					count--;
				if(count > max)
					max = count;
			}
			System.out.println(max);
		}
		sc.close();
	}
}
