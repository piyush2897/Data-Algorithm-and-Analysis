package DynamicProg;

import java.util.Scanner;

public class LongestPalindromeSubseq {
	
	static int max3(int i,int j,int k) {
		if(i>j && i>k) return i;
		else if(j>k && j>i) return j;
		else return k;
	}
	
	static int max2(int i,int j) {
		if(i>j) return i;
		return j;
	}
	
	static int lps(String str) {
		
		int arr[][] = new int[str.length()][str.length()];
		char str1[] = str.toCharArray();
		char str2[] = new StringBuilder(str).reverse().toString().toCharArray();
		
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<str.length();j++) {
				arr[i][j]=0;
			}
		}
		
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<str.length();j++) {
				if(i==0 || j==0) {
					if(str1[i] == str2[j]) arr[i][j]=1;
				}else if(str1[i] == str2[j]) {
					arr[i][j] = max3(arr[i-1][j-1]+1,arr[i-1][j],arr[i][j-1]);
				}else {
					arr[i][j] = max2(arr[i][j-1],arr[i-1][j]);
				}
			}
		}
		return arr[str.length()-1][str.length()-1];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String str = sc.next();
			int val = lps(str);
			System.out.println(val);
		}
		sc.close();
	}
}
