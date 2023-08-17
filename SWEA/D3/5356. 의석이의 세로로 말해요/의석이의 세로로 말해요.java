import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			StringBuilder sb = new StringBuilder();

			String[][] map = new String[5][15];
			for(int i = 0; i<5; i++) {
				for(int j =0; j<15; j++) {
					map[i][j] = ".";
				}
			}
			
			for(int i = 0; i<5; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j<str.length; j++) {
					 map[i][j] = str[j];
				}
			}
			
			for(int j = 0; j<15; j++) {
				for(int i =0; i<5; i++) {
					if(!map[i][j].equals(".")) {
						sb.append(map[i][j]);
					}
				}
			}
			
			System.out.println("#"+t+" "+sb);
			
		}
	}
}