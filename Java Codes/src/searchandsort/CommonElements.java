package searchandsort;

import java.util.Scanner;

public class CommonElements {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int[] arr1 = new int[a];
			int[] arr2 = new int[b];
			int[] arr3 = new int[c];
			
			for(int i=0;i<a;i++)
				arr1[i] = sc.nextInt();
			for(int i=0;i<b;i++)
				arr2[i] = sc.nextInt();
			for(int i=0;i<c;i++)
				arr3[i] = sc.nextInt();
			
			int i=0,j=0,k=0;
			int count =0;
			while(i<a && j<b && k<c ) {
				
				if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
					System.out.print(arr1[i] + " ");
					i++;j++;k++;
					count++;
				}
				
				if(i<a && j<b && arr1[i] < arr2[j])
					i++;
				else if(i<a && j<b && arr1[i] > arr2[j])
					j++;
				
				if(k<c && j<b &&arr2[j] < arr3[k])
					j++;
				else if(k<c && j<b &&arr2[j] > arr3[k])
					k++;

			}
			
			if(count == 0){
			    System.out.print(-1);
			}
			System.out.println();
			sc.close();
		}
	}

}
