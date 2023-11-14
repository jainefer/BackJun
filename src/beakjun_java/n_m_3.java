package beakjun_java;

import java.util.*;

public class n_m_3 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String [] arg) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		int n=sc.nextInt();
		int m=sc.nextInt();
	    
		sol(n,m,list);
		System.out.println(sb);
	}
	public static void sol(int n, int m,ArrayList arr) {
		if(m==0) {
			int size=arr.size();
			
			for(int i=0;i<size;i++) {
				sb.append(arr.get(i)+" ");
				
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n; i++){
			arr.add(i);
			
			sol(n,m-1,arr);
			arr.remove(arr.size()-1);
			
			
		}
	}
}
