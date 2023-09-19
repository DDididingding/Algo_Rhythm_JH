import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	static boolean[] visited;
	static int N;
	static int M;
	static Stack<Integer> stack;
	static List<List<Integer>> list;
	static int maxdepth;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]); //노드개수
			M = Integer.parseInt(str[1]); //간선개수
			
			list = new ArrayList<>(); //노드간의 연결 정보를 담기위한 리스트
			
			
			
			for(int n = 0; n<=N; n++) {
				list.add(new ArrayList<>());
			}
			
			for(int n = 0; n<M; n++) {
				str = br.readLine().split(" ");
				int start = Integer.parseInt(str[0]);
				int end = Integer.parseInt(str[1]);
				
				list.get(start).add(end);
				list.get(end).add(start);// 리스트에 정보저장
			}
			
//			System.out.println(list);
			visited = new boolean[N+1];
			maxdepth = 0;
			for(int i=1; i<=N; i++) {
				dfs(i,1);
				visited[i] = false;
//				System.out.println();
			}
			
			System.out.println("#"+t+" "+maxdepth);
			
		}
	}
	
	static void dfs(int start, int depth) {
		int cnt = 0;
//		System.out.print(start + " ");
		for(int i = 0; i<list.get(start).size(); i++) {//현재 노드에 연결된 노드들을 돌면서
			if(!visited[list.get(start).get(i)]) {//visited하지 않은 노드가 있으면
				cnt++;//개수를 센다
			}
		}
		if(cnt ==0) {//갈수있는 곳이 없으면(끝 노드면)
			if(maxdepth<depth) maxdepth = depth; //깊이를 저장하고 리턴
			return;
		};
		
		visited[start] = true;//나를 방문처리하고
		
		for(int i = 0; i < list.get(start).size(); i++) {
			if(!visited[list.get(start).get(i)]) { //방문하지 않은
				dfs(list.get(start).get(i),depth+1); //나랑 연결된 노드들에 대해 재귀
				visited[list.get(start).get(i)] = false; //들어갔다 나오면 방문취소.
			}
			
		}
	}
}