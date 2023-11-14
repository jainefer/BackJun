package beakjun_java;

import java.io.*;
import java.util.StringTokenizer;

public class coin1 {
    
    
    

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int [] coin= new int[n];
        int [] dp=new int[k+1];
        for(int i =0;i<n; i++) {
        	coin[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0; i<=k;i++) {
        	if(i%coin[0]==0)
        		dp[i]++;
        }
        for(int i=1;i<n;i++) {
        	for(int j=1; j<=k;j++) {
        		if(coin[i]<=j) {
        		
        			dp[j]=dp[j]+dp[j-coin[i]];
        			
        		}
        		//System.out.println(i+"���� "+j+"��°"+"dp: "+dp[j]);
        	}
        }
        System.out.print(dp[k]);
    }

   
}
