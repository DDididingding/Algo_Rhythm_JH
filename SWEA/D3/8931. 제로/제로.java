import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			Stack<Integer> stack = new Stack<>();
			int K = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int k = 1; k <= K; k++) {
				int a = Integer.parseInt(br.readLine());
				if(a == 0) {
					sum -= stack.peek();
					stack.pop();
				}else {
					sum += a;
					stack.push(a);
				}
			}
			System.out.println("#"+t+" "+sum);
			
			
		}
	}
}