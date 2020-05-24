package DynamicProg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class pair{
	int x;
	int y;
}

class comp implements Comparator<pair>{
	public int compare(pair a, pair b) {
		return a.y-b.y;
	}
}

public class MaxLenPair {
	
	static int lis(pair[] arr,int n) {
		
		Arrays.sort(arr,new comp());
		int val[] = new int[n];
		for(int i=0;i<n;i++) {
			val[i]=1;
		}
		int max=1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j].y < arr[i].x) {
					if(val[i] < val[j] + 1) {
						val[i] = val[j] + 1;
					}
				}
			}
			if(val[i]>max)
				max=val[i];
		}
		return max;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			pair []arr = new pair[n];
			for(int i=0;i<n;i++) {
				arr[i] = new pair();
				arr[i].x = sc.nextInt();
				arr[i].y = sc.nextInt();
			}
			System.out.println(lis(arr,n));
		}
		sc.close();
	}
}
