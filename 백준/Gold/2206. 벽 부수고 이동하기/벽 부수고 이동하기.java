import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[][][] visited;
	static int[][] map;
	static int[] dely = { 1, 0, 0, -1 };
	static int[] delx = { 0, 1, -1, 0 };
	static int mindepth;
	static Queue<int[]> q;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		mindepth = Integer.MAX_VALUE;
		
		
		q = new LinkedList<int[]>();
		bfs(0,0);

		if (mindepth == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(mindepth);

		}

	}

	private static void bfs(int y, int x) {
		visited[y][x][0] = true;
		q.offer(new int[] {y,x,0,1});
		while(!q.isEmpty()) {
			int[] v = q.poll();
			int row = v[0];
			int col = v[1];
			int cnt = v[2];
			int len = v[3];
			
			if(row == N-1 && col == M-1) {
				if(len<mindepth) mindepth = len;
			}
			
			for(int d = 0 ; d<4; d++) {
				int nr = row+dely[d];
				int nc = col+delx[d];
				
				if(nr >= 0 && nr < N && nc >=0 && nc < M) {
					if(map[nr][nc] == 0 && !visited[nr][nc][cnt]) {
						visited[nr][nc][cnt] = true;
						q.offer(new int[] {nr, nc, cnt, len+1});
					}
					
					if(map[nr][nc] == 1 && cnt == 0 && !visited[nr][nc][cnt+1]) {
						visited[nr][nc][cnt+1] = true;
						q.offer(new int[] {nr, nc, cnt+1, len+1});
					}
				}
			}
		}
		
	}

}