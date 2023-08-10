import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		for(int t = 1; t<=10; t++) {
			int sum = 0;
			int MAX = 0;
			
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			String[][] strmap = new String[100][100];
			for(int i = 0; i < 100; i++) {
				strmap[i] = br.readLine().split(" ");
			}
			
			for(int i = 0; i < 100; i++) { // 행 덧셈
				sum = 0;
				for(int j = 0 ; j < 100; j++) {
					
					map[i][j] = Integer.parseInt(strmap[i][j]);
					
					sum += map[i][j];
					
				}
				if(sum>MAX) MAX = sum;
			}
			
			for(int j = 0; j < 100; j++) { // 열 덧셈
				sum = 0;
				for(int i = 0 ; i < 100; i++) {					
					sum += map[i][j];
					
				}
				if(sum>MAX) MAX = sum;
			}
			
			sum = 0;
			for(int i = 0; i<100; i++) {
				
				sum += map[i][i];
				
			}
			if(sum>MAX) MAX = sum;
			
			sum = 0;
			for(int i = 0; i<100; i++) {
				
				sum += map[i][99-i];
				
			}
			if(sum>MAX) MAX = sum;
			
			
			
			System.out.printf("#%d %d\n", t, MAX);
		}
	}

}