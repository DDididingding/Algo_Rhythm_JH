import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	static List<List<Integer>> I;
	static boolean[] visited;
	static int node;
	static int edge;
	static boolean way;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		for(int t = 1; t<=10; t++) {
			I = new ArrayList<>();
			String [] str = br.readLine().split(" ");
			int T = Integer.parseInt(str[0]);
			int edgeCount = Integer.parseInt(str[1]);
			
			visited = new boolean[100];
			for(int i = 0 ; i<100; i++) {
				I.add(new ArrayList<>());
			}
			
			str = br.readLine().split(" ");
			for(int i = 0; i<edgeCount; i++) {
				I.get(Integer.parseInt(str[2*i])).add(Integer.parseInt(str[2*i+1]));
			}
			

			
			Stack<Integer> stack = new Stack<>();
			way = false;
			
			stack.push(0);
			while(!stack.isEmpty()) {
				int curNode = stack.pop();
				if(curNode == 99) {
					way =true;
					break;
				}
				visited[curNode] = true;
				
				for(int i = I.get(curNode).size()-1; i>=0; i--) {
					if(!visited[I.get(curNode).get(i)]) {
						stack.push(I.get(curNode).get(i));
					}
					
				}
				
			}
			
			if(way) {
				System.out.println("#"+t+" "+1);
			}else {
				System.out.println("#"+t+" "+0);
			}
				
			
			
		}
		
		
		
		
	}

}