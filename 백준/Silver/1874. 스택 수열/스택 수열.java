import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int n = 0;
		int[] list = new int[N+1];
		for(int i = 0; i<N; i++) {
			list[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		int j = 0; //수열의 첫번째를 가리킴
		while(n<=N) {
			if(stack.isEmpty()) {
				n++;
				stack.push(n); //1 넣고
				sb.append("+"+"\n"); // push출력
			}
			
			if(list[j] == stack.peek()) { //맨 위의 수가 현재 나와야 하는 수와 같으면 
				stack.pop(); // 꺼내고
				
				sb.append("-"+"\n"); //팝 출력
				j++; //수열의 다음 인덱스로
				if(j==N) {
					break;
				}
			}else {//다르면
				n++; //넣기 전에 증가
				stack.push(n); //스택에 푸시
				sb.append("+"+"\n"); //푸시 출력
			}
		}
		
		if(j == N) {
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
		
	}
}