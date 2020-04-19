package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kruskalAlgo {
	
	int v,e;
	Edge[] edges;
	
	class Edge {
		int src,dest,wt;
	}
	
	class Subset{
		int parent,rank;
	}
	
	class comp implements Comparator<Edge>{
		
		public int compare(Edge a , Edge b) {
			return a.wt-b.wt;
		}
		
	}
	
	kruskalAlgo(int a,int b){
		v=a;e=b;
		edges = new Edge[e];
		for(int i=0;i<e;i++)
			edges[i] = new Edge();
	}
	
	int find(Subset subset[],int i) {
		
		if(i != subset[i].parent)
			subset[i].parent = find(subset,subset[i].parent);
		return subset[i].parent;
		
	}
	
	void union(Subset subset[] ,int s, int d) {
		
		int x = find(subset,s);
		int y = find(subset,d);
		
		if(subset[x].rank < subset[y].rank) {
			subset[y].parent = x;
		}else if(subset[x].rank > subset[y].rank) {
			subset[x].parent = y;
		}else {
			subset[y].parent = x;
			subset[x].rank++;
		}
		
	}
	
	Edge[] algo(){
		
		Edge[] result = new Edge[v -1];
		Subset[] subset = new Subset[v];
		
		for(int i=0; i<v; ++i) 
			subset[i]=new Subset(); 
		for(int i=0; i<v-1; ++i) 
			result[i]=new Edge(); 
		
		for(int i=0;i<v;i++) {
			subset[i].rank=0;
			subset[i].parent=i;
		}
		
		int x = 0;
		int i = 0 ;
		while(x < v-1) {
			
			int a = find(subset,edges[i].src);
			int b = find(subset,edges[i].dest);
			
			if(a != b) {
				union(subset,a,b);
				result[x]=edges[i];
				x++;
			}
			i++;
		}
		
		return result;
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		kruskalAlgo g = new kruskalAlgo(v,e);
		
		for(int i=0;i<e;i++) {
			g.edges[i].src = sc.nextInt();
			g.edges[i].dest = sc.nextInt();
			g.edges[i].wt = sc.nextInt();
		}
		
		Arrays.sort(g.edges, g.new comp());
		
//		for(int i=0;i<e;i++) {
//			System.out.println(g.edges[i].src +":"+ g.edges[i].dest +":"+ g.edges[i].wt);
//		}

		Edge[] result = g.algo();
		
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i].src +":"+ result[i].dest +":"+ result[i].wt);
		}
		
		sc.close();
	}

}

//4
//5
//0 1 10
//0 2 6
//0 3 5
//1 3 15
//2 3 4
