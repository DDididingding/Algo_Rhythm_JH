import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int[] cal = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
			String[] str = br.readLine().split(" ");
			int m = Integer.parseInt(str[0]);
			int d = Integer.parseInt(str[1]);
			int M = Integer.parseInt(str[2]);
			int D = Integer.parseInt(str[3]);
			int days = 0;
			
			for(int i = m; i<M; i++) {
				days += cal[i];
			}
			
			days += D;
			days -= d-1;
			
			System.out.println("#"+t+" "+ days);
					
			
		}
		
	}

}