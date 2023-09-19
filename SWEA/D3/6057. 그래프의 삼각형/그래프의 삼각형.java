import java.io.*;
import java.util.*;

public class Solution {
	
	static List<List<Integer>> edge;
	static int[] threeNums;
	static int N, M;
	static boolean[] visited;
	static int triCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			edge = new ArrayList<>();//엣지 리스트 초기화
			threeNums = new int[3];
			for(int n = 0; n<= N; n++) {
				edge.add(new ArrayList<>());				
			} //간선 관계 나타내는 리스트 초기화
			
			for(int m = 0; m< M; m++) {
				str = br.readLine().split(" ");
				int node1 = Integer.parseInt(str[0]);
				int node2 = Integer.parseInt(str[1]);
				
				edge.get(node1).add(node2);
				edge.get(node2).add(node1);
			}
			
			visited = new boolean[N+1];
			//조합을 구해서 판단하는게 나으려나...
			triCnt = 0;
			for(int i = 1; i<=N-2; i++) {	
				combination(i,0);
			}
			System.out.println("#"+ t+ " "+ triCnt);
		}
		
	}
	
	static void combination(int n, int cnt) {
		threeNums[cnt] = n;
		if(cnt == 2) {
			//threeNums 받아서 이게 삼각형인지 판단한는 함수 삽입
			if(isTriangle(threeNums)) triCnt++;
			return;
		}
		for(int i = n+1; i<=N; i++) {
			combination(i, cnt+1);
		}
	}

	private static boolean isTriangle(int[] threeNums2) {
		
		if(edge.get(threeNums2[0]).contains(threeNums2[1]) &&
				edge.get(threeNums2[1]).contains(threeNums2[2]) &&
				edge.get(threeNums2[2]).contains(threeNums2[0])) {
			return true;
		}
		return false;
		
	}

}