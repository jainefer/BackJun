package beakjun_java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class longSequence {
	public static void main(String arg[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int []a=new int[n+1];
		int []dp=new int[n+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=1; i<=n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=0;
		a[0]=0;
		for(int i=1;i<=n;i++) {
			for(int j=i-1; j>=0;j--) {
				if(a[i]>a[j]) {
					if(dp[i]<dp[j]+1)
						dp[i]=dp[j]+1;
					
				}
			}
		}
		Arrays.sort(dp);
		System.out.print(dp[n]);
	}
}
