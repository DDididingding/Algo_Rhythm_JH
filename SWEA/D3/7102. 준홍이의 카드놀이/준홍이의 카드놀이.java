import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for( int t = 1; t<= T; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int max = 0;
			
			int[] nums = new int[N+M+1];
			for(int n = 1; n <=N; n++) {
				for(int m = 1; m <= M; m++) {
					nums[n+m]++;
					if(max<nums[n+m]) max = nums[n+m];
				}
			}
			
			for(int i = 2; i<= N+M; i++) {
				if(nums[i] == max) {
					sb.append(i);
					sb.append(" ");
				}
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println("#"+t+" "+sb);
			sb.setLength(0);
		}
		
	}
}