package DynamicProg;

import java.util.Scanner;

public class Palindrome_part {
	
	static int pp(String str) {
		return 0;
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
