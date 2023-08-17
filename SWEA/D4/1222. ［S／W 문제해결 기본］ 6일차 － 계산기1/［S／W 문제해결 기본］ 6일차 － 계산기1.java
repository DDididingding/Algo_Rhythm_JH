import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			String trash = br.readLine();
			String[] str = br.readLine().split("");
			StringBuilder sb = new StringBuilder();
			Stack<String> stack = new Stack<>();
			
			int sum = 0;
			for(int i = 0; i< str.length; i++) {
				if(str[i].equals("+")) {
					if(stack.isEmpty()){
						stack.push(str[i]);
					}else if(stack.peek().equals("+")) {
						
						sb.append(stack.pop());
						stack.push(str[i]);
					}else {
						stack.push(str[i]);
					}
				}else {
					sb.append(str[i]);
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}//후위 연산자로 바꾸기
			
			Stack<Integer> intStack = new Stack<>();
			for(int i = 0; i<sb.length(); i++) {
				if(intStack.isEmpty()) {
					intStack.push(sb.charAt(i)-'0');
				}else if(sb.charAt(i) == '+') {
					int a = intStack.pop();
					int b = intStack.pop();
					intStack.push(a+b);
				}else {
					intStack.push(sb.charAt(i)-'0');
				}
			}
			
			while(!intStack.isEmpty()) {
				sum += intStack.pop();
			}
			 //후위연산자 계산하기
			
			
			
			System.out.println("#"+t+" "+sum);
			
		}
	}

}