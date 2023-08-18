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
			int min = Math.min(N, M);
			
			for(int i = 2+min-1; i <= N+M-(min-1); i++) {
				sb.append(i);
				sb.append(" ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			System.out.println("#"+t+" "+sb);
			sb.setLength(0);
		}
		
	}
}