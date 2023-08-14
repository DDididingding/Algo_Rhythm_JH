import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			boolean isright = true;
			String pal = br.readLine();
			for(int i = 0; i<pal.length()/2; i++) {
				if(pal.charAt(i)!=pal.charAt(pal.length()-i-1)) {
					isright = false;
				}
			}
			if(isright) {
				System.out.println("#"+t+" "+1);
			}else {
				System.out.println("#"+t+" "+0);
			}
			
			
		}
		
	}
}