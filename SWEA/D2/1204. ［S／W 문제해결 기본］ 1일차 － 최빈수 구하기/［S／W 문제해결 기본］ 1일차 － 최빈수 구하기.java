import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");
			int[] scores = new int[1000]; //입력받을 배열
			int max_value = 0;
			int max_count = 0;
			
			for(int i = 0; i<1000; i++) {
				scores[i] = Integer.parseInt(st[i]); //숫자들 입력받기
				if(scores[i] > max_value) max_value = scores[i];
				
			}
			
			int[] Counter = new int[max_value+1];
			for(int i = 0; i<1000; i++) {
				Counter[scores[i]]++;
			}
//			System.out.println(Arrays.toString(Counter));
			
			for(int i = 0; i<max_value+1; i++) {
				if(Counter[i]>max_count) max_count = Counter[i];
			}
//			System.out.println(max_count);
//			System.out.println(Counter[71]);
			
			for(int i = max_value; i>=0; i--) {
				if(Counter[i] == max_count) {
					System.out.println("#"+t+" "+i);
					break;
				}
			}
			
			
			
			
		}
		
		
		
		
	}
	
	
}