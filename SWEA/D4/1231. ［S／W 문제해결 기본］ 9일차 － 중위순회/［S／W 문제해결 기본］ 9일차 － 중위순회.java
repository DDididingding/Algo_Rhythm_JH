import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String[] tree;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			for(int i = 1; i<= N; i++) {
				String[] str = br.readLine().split(" ");
				tree[i] = str[1];
			}
			
			System.out.print("#"+t+" ");
			LVR(1);
			System.out.println();
		}
		
		
	}
	
	static void LVR(int node) {
		if(node<N+1) {
		LVR(node*2);
		
			System.out.print(tree[node]);
		
		LVR(node*2+1);
		}
	}
	
}