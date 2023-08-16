import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			String str = br.readLine();
			int cnt = 0;
			int sum = 0;
			
			for(int i = 0; i< str.length(); i++) {
				if(str.charAt(i) =='(') {
					if(str.charAt(i+1) == ')') {
						sum += cnt;
						i++;
					}else {
						cnt++;
					}
						
				}else if(str.charAt(i) == ')'){
					sum +=1;
					cnt--;
				}
				
			}
			
			System.out.println("#"+t+" "+sum);
		}
		
		
		
		
		
		
	}

}