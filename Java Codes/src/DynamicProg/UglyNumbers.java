package DynamicProg;

import java.util.Scanner;

public class UglyNumbers {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		long u[]=new long[10001];
		u[0]=1;
		
		int i2=0,i3=0,i5=0;
		long next_i2 = 2;
		long next_i3 = 3;
		long next_i5 = 5;
		
		for(int i=1;i<10001;i++) {
			
			u[i] = Math.min(next_i2, Math.min(next_i3, next_i5));
			
			if(u[i] == next_i2) {
				i2++;
				next_i2 = u[i2]*2;
			}
			
			if(u[i] == next_i3) {
				i3++;
				next_i3 = u[i3]*3;
			}
			
			if(u[i] == next_i5){
				i5++;
				next_i5 = u[i5]*5;
			}
		}
		
		while(t-->0) {
			int n=sc.nextInt();
			System.out.println(u[n-1]);
		}
		sc.close();
	}
}
