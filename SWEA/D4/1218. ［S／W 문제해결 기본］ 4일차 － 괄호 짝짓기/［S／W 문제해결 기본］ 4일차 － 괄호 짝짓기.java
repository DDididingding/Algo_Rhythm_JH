import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t<=10; t++) {
			
			String trash = br.readLine();
			String str = br.readLine();
			boolean good = true;
			Stack<String> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				if(stack.isEmpty()) {
					stack.push(String.valueOf(str.charAt(i)));
				}else if(stack.peek().equals("(")) {
					if(str.charAt(i) == ')') {
						stack.pop();
					}else if(str.charAt(i) == ']'||str.charAt(i) == '}'||str.charAt(i) == '>') {
						System.out.println("#"+t+" "+0);
						good = false;
						break;
					}else{
						stack.push(String.valueOf(str.charAt(i)));
					};
						
				}else if(stack.peek().equals("[")) {
					if(str.charAt(i) == ']') {
						stack.pop();
					}else if(str.charAt(i) == ')'||str.charAt(i) == '}'||str.charAt(i) == '>') {
						System.out.println("#"+t+" "+0);
						good = false;
						break;
					}else{
						stack.push(String.valueOf(str.charAt(i)));
					};
						
				}else if(stack.peek().equals("{")) {
					if(str.charAt(i) == '}') {
						stack.pop();
					}else if(str.charAt(i) == ']'||str.charAt(i) == ')'||str.charAt(i) == '>') {
						System.out.println("#"+t+" "+0);
						good = false;
						break;
					}else{
						stack.push(String.valueOf(str.charAt(i)));
					};
						
				}else if(stack.peek().equals("<")) {
					if(str.charAt(i) == '>') {
						stack.pop();
					}else if(str.charAt(i) == ']'||str.charAt(i) == '}'||str.charAt(i) == ')') {
						System.out.println("#"+t+" "+0);
						good = false;
						break;
					}else{
						stack.push(String.valueOf(str.charAt(i)));
					};
						
				}else {
					stack.push(String.valueOf(str.charAt(i)));
				}
				
			}
			
			if(good) {
				System.out.println("#"+t+" "+1);
			}
			stack.clear();
			
		}
	}

}