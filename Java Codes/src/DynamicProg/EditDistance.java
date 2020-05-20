package DynamicProg;

import java.util.Scanner;

public class EditDistance {
	
	static int mini(int a,int b,int c) {
		if(a<b && a<c)
			return a;
		else if(b<a && b<c)
			return b;
		return c;
	}
	
	static int Edit(String str1, String str2, int m, int n) {
		int count[][] = new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0)
					count[i][j] = j;
				else if(j==0)
					count[i][j] = i ;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					count[i][j] = count[i-1][j-1];
				else
					count[i][j] = mini(count[i-1][j],count[i][j-1],count[i-1][j-1]) + 1;
			}
		}
		
		return count[m][n];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			String str1 = sc.next();
			String str2 = sc.next();
			
			int ans = Edit(str1,str2,m,n);
			
			System.out.println(ans);
		}
		sc.close();
	}
}
