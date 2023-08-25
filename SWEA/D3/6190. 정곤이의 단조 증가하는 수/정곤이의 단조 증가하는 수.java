import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] numList = new int[N];
			
			for(int i = 0; i<N; i++) {
				numList[i] = Integer.parseInt(str[i]);
			}
			
			int max = -1;
			for(int a = numList.length-1; a>=1; a--) {
				for(int b = a-1; b>=0; b--) {
					int now = numList[a]*numList[b];
					if(increase(now)) {
						max = Math.max(max, now);
					}
					
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
		
		
	}
	
	static boolean increase(int now) {
		String s = Integer.toString(now);
		for(int i = 1; i<s.length(); i++) {
			if(s.charAt(i-1)>s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}