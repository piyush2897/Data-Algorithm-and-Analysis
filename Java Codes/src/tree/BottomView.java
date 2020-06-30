package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class Node{
  int data;
  int hd;
  Node left;
  Node right; 

  public Node(int key){
      data = key;
      hd = Integer.MAX_VALUE;
      left = right = null;
  }
}

public class BottomView {
	
	static Node makeTree(String str) {
		
		if(str.length()==0 ||str.charAt(0)=='N')
			return null;
		
		String[] arr = str.split(" ");
		Node head = new Node(Integer.parseInt(arr[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		
		int i=1;
		while(!queue.isEmpty() && i<arr.length) {
			
			Node currNode = queue.poll();
			String currVal = arr[i];
			
			if(!currVal.equals("N")) {
				currNode.left = new Node(Integer.parseInt(arr[i]));
				queue.add(currNode.left);
			}
			
			i++;
			if(i>=arr.length)
				break;
			
			currVal = arr[i];
			if(!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(arr[i]));
				queue.add(currNode.right);
				
			}
			i++;
		}
		
		return head;
	}
	
	static void printInOrder(Node head) {
		
		if(head == null) return;
		printInOrder(head.left);
		System.out.print(head.data+" ");
		printInOrder(head.right);
		
	}
	
	static void bottomView(Node node) {
		
		if(node == null) return;
		node.hd=0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Map<Integer,Integer> map = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			
			Node x = queue.poll();
			int hd = x.hd;
			map.put(hd, x.data);
			
			if(x.left!=null) {
				Node l = x.left;
				l.hd = hd-1;
				queue.add(l);
			}
			
			if(x.right!=null) {
				Node r = x.right;
				r.hd = hd+1;
				queue.add(r);
			}
		}
		
		Iterator<Entry<Integer,Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next().getValue()+" ");
		}
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			String s = sc.nextLine();
			Node head = makeTree(s);
			//printInOrder(head);
			bottomView(head);
			System.out.println();
		}
		sc.close();
	}
}
