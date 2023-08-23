import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] pascal;
		int[] pascal1;
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			pascal = new int[N];
			pascal1 = new int[N];
			System.out.println("#"+t);
			for(int n = 1; n<=N; n++) {
				
				for(int j = 0; j<n; j++) {
					if(j == 0 || j==n-1) {
						pascal1[j] = 1;
					}else {
						pascal1[j] = pascal[j-1]+pascal[j];
					}
					
				}
				for(int j = 0; j<n; j++) {
					sb.append(pascal1[j]+" ");
					pascal[j] = pascal1[j];
				}
				sb.deleteCharAt(sb.length()-1);
				
				System.out.println(sb);
				sb.setLength(0);
			}
			
			
			
		}
		
	}

}