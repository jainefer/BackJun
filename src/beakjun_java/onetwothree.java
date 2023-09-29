package beakjun_java;

import java.io.*;
public class onetwothree {
	public static void main(String arg[]) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t=Integer.parseInt(br.readLine());
		int [] dp=new int[1000];
		int []n=new int[t];
		for(int i=0; i<t;i++) {
			n[i]=Integer.parseInt(br.readLine());
		}
		dp[0]=1;
		dp[1]=2;
		dp[2]=4;
		for(int i=0;i<t;i++) {
			for(int j=3; j<n[i];j++) {
				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			}
			bw.write(String.valueOf(dp[n[i]-1])+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}
