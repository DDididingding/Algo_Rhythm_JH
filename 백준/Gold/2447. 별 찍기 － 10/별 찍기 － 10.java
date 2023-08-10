import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		sb = new StringBuilder();
		
		countingStar(0, 0, N, 1);
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		
	}
	
	static void countingStar(int x, int y, int n, int idx) {
		
		if(idx==5) { //탈출조건
			for(int i = x; i<x+n; i++) {
				for(int j = y; j<=y+n; j++) {
					map[i][j] = " ";
				}
			}
		}else if(n == 1) {
			map[x][y] = "*";
		}else {
			n = n/3;
			countingStar(x, y, n, 1);
			countingStar(x, y+n, n, 2);
			countingStar(x, y+n+n, n, 3); //윗 세개
			
			countingStar(x+n, y, n, 4);
			countingStar(x+n, y+n, n, 5);
			countingStar(x+n, y+n+n, n, 6);//중간 세개
			
			countingStar(x+n+n, y, n, 7);
			countingStar(x+n+n, y+n, n, 8);
			countingStar(x+n+n, y+n+n, n, 9);//마지막세개
			
		}
		
		
		
	}

}