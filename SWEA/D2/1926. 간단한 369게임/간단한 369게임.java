import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			String st = Integer.toString(i);
			if(st.contains("3")||st.contains("6")||st.contains("9")) {
				for(int s = 0; s<st.length(); s++) {
					if(st.charAt(s) == '3'||st.charAt(s) == '6'||st.charAt(s) == '9') {
						sb.append("-");
					}
					
				}
			}else {
				sb.append(i);
			}
			sb.append(" ");
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		
	}
}