import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static String[][] map;
	static String[][] map1;
	static boolean[][] visited;
	static int cnt;
	static int cntt;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static class node{
		int y;
		int x;
		
		node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new String[N][N]; //지도
		map1 = new String[N][N];
		visited = new boolean[N][N]; //방문처리

		
		for(int i = 0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				map[i][j] = str[j];
				if(str[j].equals("R")) {
					map1[i][j] = "G";
				}else {
					map1[i][j] = str[j];
				}
			}
		}
		
		cnt = 0;
		
		
		Queue<node> q = new LinkedList<node>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) { //각 칸에 대해서
				if(!visited[i][j]) { // 아직 방문하지 않은 칸이라면
					cnt++;
					
					
					q.offer(new node(i,j)); //큐에 넣고
					visited[i][j] = true; //방문처리
					
					while(!q.isEmpty()) {
						node curnode = q.poll();
						for(int d = 0; d<4; d++) {
							if(curnode.y+dy[d] <0 || curnode.y+dy[d] >=N|| curnode.x+dx[d] <0|| curnode.x+dx[d] >=N) {
								//인덱스를 넘어가면 아무것도 안함
							}else {//인덱스를 안넘어가면
								if(map[curnode.y][curnode.x].equals(map[curnode.y+dy[d]][curnode.x +dx[d]]) && !visited[curnode.y+dy[d]][curnode.x +dx[d]]) { 
									//탐색하려는 노드와 내가 같다면 && 방문하지 않은 곳이라면
								q.offer(new node(curnode.y+dy[d],curnode.x +dx[d])); //큐에 그 노드를 넣고
								visited[curnode.y+dy[d]][curnode.x +dx[d]] = true; //방문처리 해주고
								}
							}
							
						}
					}
					
					
					
				}
				
			}
			
		}
		
		//적록색약
		
		cntt = 0;
		
		visited = new boolean[N][N]; //방문처리 초기화
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) { //각 칸에 대해서
				if(!visited[i][j]) { // 아직 방문하지 않은 칸이라면
					cntt++;
					
					
					q.offer(new node(i,j)); //큐에 넣고
					visited[i][j] = true; //방문처리
					
					while(!q.isEmpty()) {
						node curnode = q.poll();
						for(int d = 0; d<4; d++) {
							if(curnode.y+dy[d] <0 || curnode.y+dy[d] >=N|| curnode.x+dx[d] <0|| curnode.x+dx[d] >=N) {
								//인덱스를 넘어가면 아무것도 안함
							}else {//인덱스를 안넘어가면
								if(map1[curnode.y][curnode.x].equals(map1[curnode.y+dy[d]][curnode.x +dx[d]]) && !visited[curnode.y+dy[d]][curnode.x +dx[d]]) { 
									//탐색하려는 노드와 내가 같다면 && 방문하지 않은 곳이라면
								q.offer(new node(curnode.y+dy[d],curnode.x +dx[d])); //큐에 그 노드를 넣고
								visited[curnode.y+dy[d]][curnode.x +dx[d]] = true;
								}//방문처리 해주고
							}
							
						}
					}
					
					
					
				}
				
			}
			
		}
		
		
		System.out.println(cnt+" "+ cntt);
		
	}

}