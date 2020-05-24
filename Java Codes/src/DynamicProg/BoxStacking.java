package DynamicProg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Box{
	int x,y,z;
	Box(int a,int b,int c){
		x=a;
		y=b;
		z=c;
	}
}

class tcomp implements Comparator<Box>{
	public int compare(Box a,Box b) {
		return b.x*b.y - a.x*a.y;
	}
}

public class BoxStacking {
	
	static int min(Box a) {
		if(a.x < a.y)
			return a.x;
		return a.y;
	}
	
	static int max(Box a) {
		if(a.x > a.y)
			return a.x;
		return a.y;
	}
	
	static int compare(Box i,Box j) {
		int is = min(i);
		int ib = max(i);
		int js = min(j);
		int jb = max(j);
		
		if(is>js && ib>jb) return 1;
		
		return 0;
	}
	
	static int lis(Box[] arr,int n) {
		int val[] = new int[n];
		for(int i=0;i<n;i++)
			val[i]=1;
		val[0]=arr[0].z;
		int max=val[0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(compare(arr[j],arr[i]) == 1 && val[i]<val[j] + arr[i].z) {
					val[i] = val[j] + arr[i].z;
				}
			}
			if(val[i]>max)
				max=val[i];
		}
		return max;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			Box arr[] = new Box[3*n];
			for(int i=0;i<n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				arr[3*i] = new Box(a,b,c);
				arr[3*i+1] = new Box(c,b,a);
				arr[3*i+2] = new Box(a,c,b);
			}
			Arrays.sort(arr,new tcomp());
			System.out.println(lis(arr,3*n));
		}
		sc.close();
	}
}
