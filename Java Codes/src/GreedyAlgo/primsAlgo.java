package GreedyAlgo;

import java.util.ArrayList;
import java.util.Scanner;

public class primsAlgo {
	
	static int pickmin(int result[],boolean flag[]) {
		
		int min = Integer.MAX_VALUE;
		int index=-1;
		for(int i=0;i<result.length;i++) {
			if(result[i]<=min && flag[i] == false) {
				min = result[i];
				index=i;
			}
		}
		return index;
	}
	
	static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph){
		
		int[] result = new int[V];
		boolean[] flag   = new boolean[V];
		
		result[0]=0;
		
		for(int i=1;i<V;i++) {
			result[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<V;i++) {
			flag[i] = false;
		}
		
		int k=0;
		while(k++ < V) {
			
			int min = pickmin(result,flag);
			flag[min] = true;
			
			for(int i=0;i<V;i++) {
				if(flag[i] == false && result[i] > graph.get(min).get(i)) {
					result[i] = graph.get(min).get(i);
				}
			}
		}
		
		int ans=0;
        for(int i=0;i<V;i++) {
        	ans += result[i];
        }
        return ans;
    }
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
			for(int i=0;i<V;i++) {
				ArrayList<Integer> node = new ArrayList<>();
				for(int j=0;j<V;j++)
					node.add(Integer.MAX_VALUE);
				graph.add(node);
			}
			
			int i=1;
			while(i++ <= E) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				u--;
				v--;
				graph.get(u).set(v, w);
				graph.get(v).set(u, w);
			}
			
			System.out.println(spanningTree(V,E,graph));
			
		}
		sc.close();
	}
	
}
