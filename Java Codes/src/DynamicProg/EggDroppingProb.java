package DynamicProg;

import java.util.Scanner;

public class EggDroppingProb {
	
	static int max(int a,int b) {
		if(a>b)
			return a;
		return b;
	}
	
	static int edp(int n,int k) {
		
		int arr[][] = new int[n+1][k+1];
		
		for(int i=0;i<=k;i++)
			arr[1][i]=i;
		for(int i=0;i<=n;i++){
			arr[i][0]=0;
			arr[i][1]=1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=2;j<=k;j++) {
				arr[i][j] = Integer.MAX_VALUE;
				for(int x=1;x<=j;x++) {
					int res = 1 + max(arr[i-1][x-1],arr[i][j-x]);
					if(res < arr[i][j])
						arr[i][j]=res;
				}
			}
		}
		
		return arr[n][k];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int threshold = edp(n,k);
			System.out.println(threshold);
		}
		sc.close();
	}
}
