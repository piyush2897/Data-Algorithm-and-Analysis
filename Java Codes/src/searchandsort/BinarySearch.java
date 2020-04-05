package searchandsort;

import java.util.Scanner;

class BinarySearch{
	
	static boolean Binary_Search(int arr[],int s ,int e,int val) {
		
		if(s<=e) {
			
			int mid = (s+e)/2;
			
			if(arr[mid] == val)
				return true;
			if(arr[mid] < val)
				return Binary_Search(arr, mid+1, e, val);
			else
				return Binary_Search(arr, s, mid-1, val);
			
		}
		return false;
	}
    
	public static void main (String[] args){
	    int t,n,k;
	    Scanner sc = new Scanner(System.in);
	    t = sc.nextInt();
	    for(;t != 0;t-- ){
	        n = sc.nextInt();
	        k = sc.nextInt();
	        
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++) {
	        	arr[i] = sc.nextInt();
	        }
	        
	        boolean result = Binary_Search(arr,0,n-1,k);
	        if(result == true)
	        	System.out.println(1);
	        else
	        	System.out.println(-1);
	    }
	    sc.close();
	 }
}