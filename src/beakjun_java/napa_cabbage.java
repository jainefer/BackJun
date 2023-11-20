package beakjun_java;
import java.util.*;
import java.io.*;
public class napa_cabbage {
	static int count=0;
	//방향설정
	static int[] strX= {0,0,-1,1};
	static int[] strY= {-1,1,0,0};
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int x=0;
			int y=0;
			int m=sc.nextInt();
			int n=sc.nextInt();
			int k=sc.nextInt();
			int [][]field=new int[m][n];
			
			for(int j=0;j<k;j++) {
				x=sc.nextInt();
				y=sc.nextInt();
				field[x][y]=1;
			}
			sol(field,m,n);
			System.out.println(count);
			count=0;
		}
		
	}
	public static void counting_cabbage(int[][]field,int x,int y,int m,int n) {
		for(int i=0;i<4;i++) {
			if((x+strX[i]>=0&&x+strX[i]<m)&&((y+strY[i]>=0&&y+strY[i]<n))) {
				if(field[x+strX[i]][y+strY[i]]==1) {
					field[x+strX[i]][y+strY[i]]=0;
					counting_cabbage(field,x+strX[i],y+strY[i],m,n);
				}
			}
		}
		return;
	}
	public static void sol(int [][]field,int m,int n) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(field[i][j]==1) {
					count++;
					counting_cabbage(field,i,j,m,n);
				}
			}
		}
	}
}
