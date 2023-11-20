package beakjun_java;
import java.util.*;
import java.io.*;
public class virus {
	static int count=0;
	public static void main(String arg[]) {
		//입력단계
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int firstNode=0;
		int nextNode=0;
		ArrayList<Integer>[] arr= new ArrayList[101];
		for(int i=0; i<=100;i++)
			arr[i]=new ArrayList<Integer>();
		boolean []visted=new boolean[n+1];
		Arrays.fill(visted, false);
		//입력받은 간선들을 각 노드의 정점 배열에 저장
		for(int i=0;i<k;i++) {
			firstNode=sc.nextInt();
			nextNode=sc.nextInt();
			arr[firstNode].add(nextNode);
			arr[nextNode].add(firstNode);
		}
		//만약 정점이 하나가 아닐경우 계산
		if(n!=1)
			DFS(arr,1,visted);
		
		System.out.println(count);
		
	}
	public static void DFS(ArrayList<Integer>[] arr,int n,boolean []visted){
		visted[n]=true;
		if(n!=1)//시작 지점이 아닐시 계산
			count++;
		for (int i :arr[n]) {//이미 방문했는지 확인 
			if(visted[i]==false) {
				DFS(arr,i,visted);
			}
			
		}
		
	
		
	}

	

}
