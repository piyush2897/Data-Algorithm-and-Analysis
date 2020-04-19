package GreedyAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DetectCycle {
	
	Integer v;
	List<List<Integer>> edge;
	
	DetectCycle(int x){
		this.v = x;
		edge = new ArrayList<>(x);
		
		for(Integer i=0;i<x;i++) {
			edge.add(new LinkedList<>());
		}
	}
	
	void addedge(int a,int b) {
		edge.get(a).add(b);
	}
	
	boolean checkCycle(int i,boolean vis[],boolean stack[]) {
		
		if(stack[i] == true)
			return true;
		
		if(vis[i] == true)
			return false;
		
		vis[i] = true;
		stack[i] = true;
		
		List<Integer> list = edge.get(i);
		
		for(Integer c : list) {
			if(checkCycle(c,vis,stack))
				return true;
		}
		
		stack[i] = false;
		
		return false;
		
	}
	
	boolean isCyclic() {
		
		boolean[] visited  = new boolean[this.v];
		boolean[] recStack = new boolean[this.v];
		
		for(int i=0;i<v;i++) {
			if(checkCycle(i,visited,recStack))
				return true;
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int v = sc.nextInt();
			DetectCycle g = new DetectCycle(v);
			int edge = sc.nextInt();
			for(int i=0;i<edge;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				g.addedge(a,b);
			}
			if(g.isCyclic()) {
				System.out.println("Cyclic");
			}else {
				System.out.println("Non-Cyclic");
			}
		}
		sc.close();
		
	}

}
