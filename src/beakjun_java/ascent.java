package beakjun_java;

import java.io.*;
import java.util.StringTokenizer;

public class ascent {
    
    
    

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int [][]dp=new int[1010][1000];
        int count=0;
        for(int i=0;i<10;i++) {
        	dp[0][i]=1;
        	count++;
        }
      
        
        
        for(int i=1;i<n;i++) {
        	dp[i][0]=GetSum(dp[i-1])%10007;
	        for(int j=1; j<10;j++) {
	        	dp[i][j]=(dp[i][j-1]-dp[i-1][j-1]);
	        	
	        	if (dp[i][j] < 0) {
	                dp[i][j] += 10007; // 음수를 방지하기 위해 10007을 더해줌
	            }
	        }
	        
	        
        }
        System.out.print(GetSum(dp[n-1])%10007);
    }
    public static int  GetSum(int[]arr) {
    	int count=0;
    	for(int i=0;i<10;i++) {
    		count+=arr[i];
    	}
    	return count;
    }

   
}
