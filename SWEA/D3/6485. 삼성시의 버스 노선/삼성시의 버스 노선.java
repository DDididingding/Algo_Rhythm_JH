import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			
			int[] Bus = new int[5001];
			int N = Integer.parseInt(br.readLine());
			for(int n = 0; n<N; n++) {
				String[] str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				for(int S = a; S<=b; S++) {
					Bus[S]++;
				}
			}
			
			sb.append("#"+t+" ");
			int P = Integer.parseInt(br.readLine());
			for(int p = 0; p<P; p++) {
				int c = Integer.parseInt(br.readLine());
				sb.append(Bus[c]+" ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
			sb.setLength(0);
		}
		
	}

}