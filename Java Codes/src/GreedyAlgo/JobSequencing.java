package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class PNode {
	int index;
	int dl;
	int profit;
	
	PNode(int i,int d,int p){
		index = i;dl=d;profit=p;
	}
}

class compa implements Comparator<PNode> {
	public int compare(PNode a , PNode b) {
		return b.profit-a.profit;
	}
}

public class JobSequencing {
	
	static int checkAva(int[] flag , int n) {
		for(int i=n;i>0;i--) {
			if(flag[i]==-1)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			PNode[] arr = new PNode[n];
			for(int i=0;i<n;i++) {
				arr[i] = new PNode(sc.nextInt(),sc.nextInt(),sc.nextInt());
			}
			Arrays.sort(arr, new compa());
			int[] flag = new int[101];
			for(int i=1;i<101;i++)
				flag[i]=-1;
			int profit =0;
			int count =0;
			for(int i=0;i<n;i++) {
				if(flag[arr[i].dl] == -1) {
					flag[arr[i].dl] = 1;
					count++;
					profit+=arr[i].profit;
				}else {
					int x = checkAva(flag,arr[i].dl);
					if(x!=-1) {
						flag[x] = 1;
						count++;
						profit+=arr[i].profit;
					}
				}
			}
			System.out.println(count + " " + profit);
		}
		sc.close();
	}

}
