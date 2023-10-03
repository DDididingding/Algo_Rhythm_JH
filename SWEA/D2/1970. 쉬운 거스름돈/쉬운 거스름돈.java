import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			// 50000 10000 5000 1000 500 100 50 10
			int[] Money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] cnt = new int[8];
			
			for(int i = 0; i <8; i++) {
				cnt[i] = N/Money[i];
				N = N%Money[i];
			}
			System.out.println("#"+t);
			for(int i = 0; i<8; i++) {
				
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
		}
	}
}