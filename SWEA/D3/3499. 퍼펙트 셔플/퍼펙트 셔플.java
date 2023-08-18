import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			
			int many = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			int A = 0;
			if(many%2 != 0) many++;
			int B = many/2;
			int B0 = many/2;
			while(A < B0) {
				sb.append(cards[A++]);
				sb.append(" ");
				if(B+1 <= cards.length) {
				sb.append(cards[B++]);
				sb.append(" ");
				}
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println("#"+t+" "+sb);
			sb.setLength(0);
			
			
		}
		
		
	}

}