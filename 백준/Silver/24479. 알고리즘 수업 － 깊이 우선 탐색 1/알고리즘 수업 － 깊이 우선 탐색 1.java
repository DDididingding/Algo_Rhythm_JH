import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
	
	static List<List<Integer>> I = new ArrayList<>();
	static boolean[] visited;
	static int[] order;
	static int cnt;
	static int node;
	static int edge;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		node = Integer.parseInt(str[0]);
		edge = Integer.parseInt(str[1]);
		int R = Integer.parseInt(str[2]);
		
		visited = new boolean[node+1]; //visited초기화
		
		
		for(int i = 0; i <= node; i++) {
			I.add(new ArrayList<>()); // I에  노드 개수만큼 ArrayList를 추가.
		}
		
		for(int m = 1; m <=edge; m++) {
			str = br.readLine().split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			I.get(A).add(B);
			I.get(B).add(A);	//노드 사이의 관계를 추가
		}
		
		for(int i = 1; i<=node; i++) {
			Collections.sort(I.get(i)); //노드간의 관계를 정렬
		}
		
//		System.out.println(I);
		
		
		order = new int[node+1]; //order, cnt 초기화
		cnt = 1;
		//이제 탐색을 시작해야함
		dfs(R);
		
		for(int i = 1; i<=node; i++) {
			System.out.println(order[i]);
		}
		
		
	}
	
	static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int curNode = stack.pop();
			if (visited[curNode]) continue;
//			System.out.println(curNode + " " + cnt);
			order[curNode] = cnt++;
			visited[curNode] = true; //첫 노드는 입력
			
			for(int i = I.get(curNode).size()- 1 ; i>=0; i--) {
				if(!visited[I.get(curNode).get(i)]) {
					stack.push(I.get(curNode).get(i));
				}
			}
			
			
		}
		
	}
}