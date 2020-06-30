package DynamicProg;

import java.util.Scanner;

public class LongestPalinString {
	
	static String lps(String str) {
		
		char[] str1 = str.toCharArray();
//		char[] str2 = new StringBuilder(str).reverse().toString().toCharArray();
		
		int n = str.length();
		int arr[][] = new int[n][n];
		
		int s=0,e=0;
		int max=1;
		
		for(int i=0;i<n;i++)
			arr[i][i]=1;
		int flag=0;
		for(int i=0;i<n-1;i++) {
			if(str1[i] == str1[i+1]) {
				arr[i][i+1]=2;
				max=2;
				if(flag==0) {
					s=i;
					e=i+1;
					flag=1;
				}
			}
		}
		
		for(int l=3;l<=n;l++) {
			for(int i=0;i<=n-l+1;i++) {
				int j=l+i-1;
				if(i<n && j<n && str1[i] == str1[j] && arr[i+1][j-1]!=0) {
					arr[i][j] = arr[i+1][j-1]+2;
					if(arr[i][j] > max) {
						max=arr[i][j];
						s=i;
						e=j;
					}
				}
			}
		}
		
		
		//print arr
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return str.substring(s, e+1);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String str = sc.next();
			String ans = lps(str);
			System.out.println(ans);
		}
		sc.close();
	}
}

//otafsngqvoijxuvqbztv
