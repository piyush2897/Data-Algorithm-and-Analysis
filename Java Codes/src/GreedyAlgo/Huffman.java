package GreedyAlgo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node{
	char ch;
	int freq;
	Node left;
	Node right;
	
	Node(char c,int f){
		ch=c;freq=f;left=null;right=null;
	}
	
	Node(){
		left=null;right=null;
	}
}

class comp implements Comparator<Node>{
	 public int compare(Node a, Node b) {
		return a.freq-b.freq;
	}
}

public class Huffman {
	
	
	void generateCode(Node pq,String str) {
		
		if(pq.ch=='-') {
			generateCode(pq.left,str+"0");
			generateCode(pq.right,str+"1");
		}else {
			System.out.print(str +" ");
		}
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String str = sc.next();
			PriorityQueue<Node> pq = new PriorityQueue<Node>(str.length(),new comp());
			for(int i=0;i<str.length();i++) {
				Node node = new Node(str.charAt(i),sc.nextInt());
				pq.add(node);
			}
			Huffman huffman = new Huffman();
			
			while(pq.size() > 1) {
				
				Node a = pq.peek();
				pq.poll();
				
				Node b = pq.peek();
				pq.poll();
				
				Node node = new Node('-',a.freq+b.freq);
				if(a.freq <= b.freq) {
					node.left=a;
					node.right=b;
				}else {
					node.left=b;
					node.right=a;
				}
				
				pq.add(node);
			}
			
			huffman.generateCode(pq.peek(),"");
			System.out.println();
		}
		sc.close();
	}

}

//1
//abcdef
//9 12 16 13 5 45
