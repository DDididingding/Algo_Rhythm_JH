import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);
			int K = Integer.parseInt(st[1]);
			int[][] map = new int[N][N];
			int ans = 0;
			int cnt = 0;
			
			for(int n = 0; n <N; n++) {
				st = br.readLine().split(" ");
				for(int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st[m]);
				}
			}
			

			for(int i = 0; i<N; i++) { //행 우선 탐색
				for (int j = 0; j<N; j++) {
					if(map[i][j] == 1) {
						cnt++;	//1이 있으면 공백 카운터 +1
						if(cnt==K) ans++;
						if(cnt==K+1) ans--;
					}else {
						cnt = 0;
					}
					
					if(j == N-1) {
						cnt = 0;	//행 하나 탐색 후 카운터 초기화
					}
				}
			}
			cnt = 0; //행 탐색 후 cnt 초기화
			
			for(int i = 0; i<N; i++) { //열우선 탐색
				for (int j = 0; j<N; j++) {
					if(map[j][i] == 1) {
						cnt++;
						if(cnt==K) ans++;
						if(cnt==K+1) ans--;
					}else {
						cnt = 0;
					}
					
					if(j == N-1) {
						cnt = 0; //열 하나 탐색 후 카운터 초기화
					}
				}
			}
			
			System.out.printf("#%d %d%n", t,ans);
			
			
		}
	}
}