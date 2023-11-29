package beakjun_java;
import java.util.*;
public class Budget {
	public static void main(String arg[]) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int []locals=new int[n];
		int first_sum=0;
		for(int i =0;i<n;i++) {
			locals[i]=sc.nextInt();
			first_sum+=locals[i];
		}
		int max_budget=sc.nextInt();
		Arrays.sort(locals);
		if(first_sum<=max_budget)
			System.out.println(locals[n-1]);
		else
			System.out.println(sol(0,locals[n-1],max_budget,locals));
	}
	public static int sol(int start,int end, int max_budget,int[]locals) {
		int mid=(start+end)/2;
		int sum=0;
		if(mid==end || mid==start) {
			return mid;
		}else {
			for(int i=0;i<locals.length;i++) {
				if(locals[i]>mid) {
					sum+=mid;
				}else {
				sum+=locals[i];
				}
			}
			if(sum>max_budget)
				end=mid;
			else if (sum<max_budget)
				start=mid;
			else
				return mid;
			return sol(start,end,max_budget,locals);
		}
	}

}
