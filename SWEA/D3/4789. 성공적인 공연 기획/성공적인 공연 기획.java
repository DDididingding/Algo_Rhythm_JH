import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			int pplThatWeNeed = 0;
			String[] str = br.readLine().split("");
			int[] clap = new int[str.length];
			for(int i =0; i< str.length; i++) {
				clap[i] = Integer.parseInt(str[i]);
			}
			
			for(int i = 1; i< clap.length; i++) {
				clap[i] = clap[i-1] + clap[i];
				if(clap[i-1]<i) {
					pplThatWeNeed += i-clap[i-1];
					clap[i] += i-clap[i-1];
				}
				
			}
			
			for(int i = 1; i<clap.length;i++) {
				if(clap[i-1]<i) {
					
				}
			}
			System.out.println("#" + t + " "+ pplThatWeNeed);
		}
	}

}