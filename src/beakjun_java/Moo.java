package beakjun_java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Moo {
	public static void main(String args[]) {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
			int n=Integer.parseInt(br.readLine());
			int moo_num=3;
			bw.write(GetMoo(n,moo_num,1));
			bw.flush();
			bw.close();
		
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static String GetMoo(int n,int prev_moo,int count) {
		//만약 3미만인경우는 초기값에서 찾으면 되니 바로 찾아준다
		if(n<=3) {
			if(n==1)
				return "m";
			else
				return "o";
				
		}else {
			//다음 단계의 moo 수열 값을 저장
			int new_moo=2*prev_moo+count+3;
			//만약 찾고자하는 값이 다음단계의 +count+3만큼 작고, 다음단계의 수열단계보다 크면, 다음단계의 moo수열을 재귀로 호출하고, 아니라면 (count-1)단게의 값만 남겨놓고 다시 계산한다,
			if(prev_moo+count+3<n)
				if(n<new_moo) {
					return GetMoo(n-(prev_moo+count+3),3,1);
				}
				else {
					count++;
					return GetMoo(n,new_moo,count);
				}
			else { 
				if(prev_moo+1==n)
					return "m";
				else
					return "o";
			}
		}
		
	}
}

