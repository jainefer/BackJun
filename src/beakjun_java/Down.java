package beakjun_java;


import java.util.*;

public class Down {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int [][]plates=new int[n][3];
		int max=0;
		int min=999999999;
		int [][]dp=new int[n][3];
		for(int i =0;i<n;i++) {
			for(int j = 0; j<3;j++) {
				plates[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<3;i++)
			dp[0][i]=plates[0][i];
		
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1])+plates[i][0];
			dp[i][1]=Math.max(dp[i-1][0],Math.max(dp[i-1][1], dp[i-1][2]))+plates[i][1];
			dp[i][2]=Math.max(dp[i-1][1], dp[i-1][2])+plates[i][2];
		}
		max=Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.min(dp[i-1][0], dp[i-1][1])+plates[i][0];
			dp[i][1]=Math.min(dp[i-1][0],Math.min(dp[i-1][1], dp[i-1][2]))+plates[i][1];
			dp[i][2]=Math.min(dp[i-1][1], dp[i-1][2])+plates[i][2];
		}
		min=Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
		
		System.out.println(max+" "+min);
	}

	
}
