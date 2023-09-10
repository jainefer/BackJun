package beakjun_java;

import java.io.*;
import java.util.*;

public class 트리 {
    static LinkedList<Integer> postList = new LinkedList<Integer>();

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                String firstPre = br.readLine();
                String firstIn = br.readLine();
                String[] preTemp = firstPre.split(" ");
                String[] inTemp = firstIn.split(" ");
                LinkedList<Integer> preList = new LinkedList<Integer>();
                LinkedList<Integer> inList = new LinkedList<Integer>();

                for (int j = 0; j < n; j++) {
                    preList.add(Integer.parseInt(preTemp[j]));
                    inList.add(Integer.parseInt(inTemp[j]));
                }
                //preList,inList,pre시작위치,pre끝나는위치,in시작위치,in끝나는위치
                GetTree(preList, inList, 0, n - 1, 0, n - 1);
                for (int j = 0; j < postList.size(); j++) {
                    System.out.print(postList.get(j) + " ");
                }
                System.out.println(); // 개행 추가

                postList.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GetTree(LinkedList<Integer> preorder, LinkedList<Integer> inOrder,
                               int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart <= preEnd) {//시작과 끝이 일치하면 공간이 없으므로 함수 종료
        	int root = inOrder.indexOf(preorder.get(preStart));//루트의 위치
            int leftSubtreeSize = root - inStart; //왼쪽 서브트리 사이즈는 루트의 위치에서 inStart의위치 빼기
            //왼쪽으로 가는 트리는 노드를 한칸 움직이고, 노드 사이즈까지, 
            GetTree(preorder, inOrder, preStart + 1, preStart + leftSubtreeSize, inStart, root - 1);
            GetTree(preorder, inOrder, preStart + leftSubtreeSize + 1, preEnd, root + 1, inEnd);

            postList.add(preorder.get(preStart));
        }
    }
}
