import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		
		int node = Integer.parseInt(str[0]);
		int edge = Integer.parseInt(str[1]);
		int stPoint = Integer.parseInt(str[2]);
		List<List<Integer>> I = new ArrayList<>(); //노드 수, 엣지 종류 연결받기
		
		boolean[] visited = new boolean[node+1];
		int[] order = new int[node+1]; //인덱스 번호를 그대로 노드 번호로 쓰기 위해서 +1
		
		for(int i = 0; i<=node; i++) {
			I.add(new ArrayList<>()); //노드의 연결 관계를 표시할 리스트 추가
		}
		
		
		for(int m = 1; m<=edge; m++) { //엣지 개수만큼 반복
			str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			
			I.get(start).add(end);
			I.get(end).add(start); //양방향이기 때문에 양쪽 노드에 모두 정보 추가
		}
		
		for(int i = 0; i<=node; i++) { //들어온 정보를 정렬
			Collections.sort(I.get(i));
		}
		
		//입력받기는 끝. 이제는 큐를 이용한 bfs 구현
		
		Queue<Integer> q = new LinkedList<>();// bfs에 사용할 큐 선언 
		q.add(stPoint); //큐에 시작점을 더하고
		visited[stPoint] = true; // 방문처리
		int curNode = stPoint; //일단 시작점을 현재노드로 지정
		int cnt = 1; //몇번짼지 기록을 위해
		while(!q.isEmpty()) { //큐가 비어있을 때까지 돌거야
			curNode = q.poll();//맨 앞에 있는 최근 노드를 빼고
			
			if(order[curNode] == 0) order[curNode] = cnt++; //방문 처리된 애가 첫 방문이면 순서에 넣기
			
			for(int i = 0; i < I.get(curNode).size(); i++) {
				if(!visited[I.get(curNode).get(i)]) {
					visited[I.get(curNode).get(i)] = true;
					q.add(I.get(curNode).get(i)); //나랑 연결된 방문 안한애들 다 집어넣엉 그리고 넣는다 == 방문. 작은 값부터
				}
					
			}
		}
		
		//다 돌았으면 출력해야지
		for(int i = 1; i<=node; i++) {
			sb.append(order[i]);
			sb.append("\n");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
	}

}