package DynamicProg;

import java.util.Scanner;

public class LongestCommonSunSeq {
	
	static int maxi(int i,int j,int k) {
		if(i>=j && i>=k)
			return i;
		else if(j>=i && j>=k)
			return j;
		else
			return k;
	}
	
	static int max(int i,int j) {
		if(i>j)
			return i;
		else
			return j;
	}
	
	static int LCS(String str1,String str2, int m ,int n) {
		int count[][] = new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0)
					count[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					count[i][j] = maxi(count[i-1][j],count[i][j-1],count[i-1][j-1]+1);
				}else {
					count[i][j] = max(count[i-1][j],count[i][j-1]);
				}
//				System.out.print(count[i][j] + " ");
			}
//			System.out.println();
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
			
			int len = LCS(str1,str2,m,n);
			
			System.out.println(len);
		}
		sc.close();
	}
}
