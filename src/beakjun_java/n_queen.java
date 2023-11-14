package beakjun_java;
import java.io.*;
import java.util.*;
public class n_queen {
	static int [] chess;
	static int count=0;
	public static void sol(int n,int s) {
		if(n==s) {
			count++;
			return;
		}else {
			for(int i=0; i<s;i++) {
				chess[n]=i;
				if(promise(n)) {
					sol(n+1,s);
				}
			}
		}
	}
	public static boolean promise(int n) {
		for(int i=0;i<n;i++) {
			if(chess[n]==chess[i]||n-i==Math.abs(chess[n]-chess[i]))
				return false;
			
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		chess=new int[n+1];
		sol(0,n);
		System.out.println(count);
		
		
	}

}
