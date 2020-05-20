package DynamicProg;

import java.util.Scanner;

public class Palindrome_part {
	
	static int min(int a,int b) {
		if(a<b) return a;
		return b;
	}
	
	static int pp(String str) {
		int n =str.length();
		boolean arr[][] = new boolean[n][n];
		int val[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i][i]=true;
		
		for(int l=2;l<=n;l++) {
			for(int i=0;i<n-l+1;i++) {
				int j = i+l-1;
				if(l==2) {
					arr[i][j] = (str.charAt(i) == str.charAt(j));
				}else {
					arr[i][j] = ((str.charAt(i) == str.charAt(j)) && arr[i+1][j-1]);
				}
				
			}
		}
		
		for(int i=0;i<n;i++) {
			val[i]=Integer.MAX_VALUE;
			if(arr[0][i] == true) val[i]=0;
			else {
				for(int j=0;j<i;j++) {
					 if(arr[j+1][i]==true && 1+val[j]<val[i]) {
						 val[i]=1+val[j];
					 }
				}
			}
		}
		
		return val[n-1];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String str = sc.next();
			int len = pp(str);
			System.out.println(len);
		}
		sc.close();
	}
	
}
