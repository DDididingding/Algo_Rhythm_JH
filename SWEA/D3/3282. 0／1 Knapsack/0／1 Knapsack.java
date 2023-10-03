import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int K;
	static int[] volume;
	static int[] value;
	static int maxVal;
	static int[][] sack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			
			sack = new int[N+1][K+1];
			volume = new int[N+1];
			value = new int[N+1];
			for(int n = 1; n<N+1; n++) {
				str = br.readLine().split(" ");
				volume[n] = Integer.parseInt(str[0]);
				value[n] = Integer.parseInt(str[1]);
			}
			
			for(int i = 1; i<= N; i++) {
				
				for(int j = 0; j<= K; j++) {
					if(volume[i]<=j) {
						//해당 부피에서의 최적 해는
						sack[i][j] = Math.max(sack[i-1][j], sack[i-1][j-volume[i]]+ value[i]);
						
					}else {
						sack[i][j] = sack[i-1][j]; //현재 고려할 물건의 무게가 임시 무게를 벗어나 고려할 수 없을 때 
					}
				}
			}
			
			System.out.println("#"+t+" "+sack[N][K]);

		}
	}
	
}