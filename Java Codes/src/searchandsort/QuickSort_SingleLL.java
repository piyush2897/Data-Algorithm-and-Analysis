package searchandsort;

import java.util.Scanner;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}

public class QuickSort_SingleLL{
	
	static Node head = null;
	
	static void addToLast(Node node) {
		if(head == null) {
			head = node;
		}else {
			Node temp = head;
			while(temp.next !=null)
				temp = temp.next;
			temp.next = node;
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			addToLast(new Node(sc.nextInt()));
		}
		
		Node node = GFG.quickSort(head);
		
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
			
		sc.close();
	}
	
}

class GFG
{
   static void sort(Node head, Node tail){
        
        if(head == null || tail == null)
           return ; 
        
        if(head == tail)
        	return ;
        
        Node ref = head;
        Node prev = head;
        
        while(ref!=tail){
            if(ref.data > tail.data){
                ref = ref.next;
            }else{
                int temp = ref.data;
                ref.data = prev.data;
                prev.data = temp;
                
                ref  = ref.next;
                prev = prev.next;
            }
        }
        
        int temp = tail.data;
        tail.data = prev.data;
        prev.data = temp;
        
        Node bprev = head;
        while(bprev!=null && bprev.next != prev)
            bprev = bprev.next;
            
        sort(head,bprev);
        if(prev!=null && prev!=tail)
        	sort(prev.next,tail);
        
    }
    
    public static Node quickSort(Node head)
    {
        if(head == null)
            return null;
        
        Node tail = head;
        while(tail.next !=null)
            tail = tail.next;
        
        sort(head,tail);    
        
        return head;
    }
}