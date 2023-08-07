import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			String[][] Flies = new String[N][N];
			int[][] flies = new int[N][N];
			int kill = 0;
			int maxKill = 0;
			
			for(int i = 0; i<N; i++) {
				Flies[i] = br.readLine().split(" ");
			}
			
			for(int i = 0; i <N; i++ ) {
				for(int j = 0; j <N; j++ ) {
					flies[i][j] = Integer.parseInt(Flies[i][j]);
				}
			}
					
			
			for(int i = 0; i <N-(M-1); i++ ) {
				for(int j = 0; j <N-(M-1); j++ ) {
					for(int l = i; l<i+M; l++) {
						for(int m = j; m<j+M; m++) {
							kill += flies[l][m];
						}
					}
					
					if(maxKill <= kill) maxKill = kill;
					kill = 0;
					
				}
			}
			
			System.out.println("#"+t+" "+maxKill);
			
		}
		
	}

}