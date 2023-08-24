import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] bat = new int[N][N];
			for (int i = 0 ; i<N; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j<N; j++) {
					bat[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			int del = 0;
			int sum = 0;
			for (int i = 0; i<=N/2; i++) {
				for(int j = N/2-del; j<=N/2+del; j++) {
					sum += bat[i][j];

				}
				del++;
			}
			del -=2;
			for (int i = N/2+1; i<N; i++) {
				for(int j = N/2-del; j<=N/2+del; j++) {
					sum += bat[i][j];

				}
				del--;
			}
			
			System.out.println("#"+t+" "+ sum);
		}
		
		
	}

}