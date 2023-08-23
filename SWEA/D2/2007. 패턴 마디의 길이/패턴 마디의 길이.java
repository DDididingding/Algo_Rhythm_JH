import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= 10; t++) {
			String str = br.readLine();
			
			System.out.print("#"+t+" ");
			for(int i = 1; i<str.length(); i++) {
				if(str.substring(0, i).equals(str.substring(i+1, 2*i+1))) {
					System.out.println(i+1);
					break;
				}
			}

		}
		
	}

}