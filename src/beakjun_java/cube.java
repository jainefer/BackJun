package beakjun_java;

import java.util.*;
import java.io.*;
public class cube {
	static int [] cube=new int[20];
	static int count=0;
	static boolean state=true;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length=Integer.parseInt(st.nextToken());
        int width=Integer.parseInt(st.nextToken());
        int height=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++ ) {
        	st=new StringTokenizer(br.readLine());
        	int idx=Integer.parseInt(st.nextToken());
        	cube[idx]=Integer.parseInt(st.nextToken());

        }
        GetCube(length,width,height);
        if(state==true)
        	bw.write(String.valueOf(count));
        else
        	System.out.println(-1);
        bw.flush();
        bw.close();
        
		}
	
	
	public static void GetCube(int l,int w,int h) {
		if (l==0||w==0||h==0) {
			return;
		}
		int cubeSide=0;
		//큐브 큰것 부터 찾음 
		for(int i=19;i>=0;i--) {
			
			state=false;
			cubeSide=1<<i;
			if(cubeSide<=l&&cubeSide<=w&&cubeSide<=h&&cube[i]>0) {
				
				cube[i]--;
				count++;
				state=true;
		
				break;
			}
		}
		//state가 false이면 더이상 없다는 것이므로 리턴 
		if(!state) 
			return ;
		
		
		GetCube(l-cubeSide,cubeSide,cubeSide);
		GetCube(l,w-cubeSide,cubeSide);
		GetCube(l,w,h-cubeSide);
		
	}

}
