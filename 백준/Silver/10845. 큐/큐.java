import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		int back = 0;
		int size = 0;
		for(int n = 0; n< N; n++) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("push")) {
				q.offer(Integer.parseInt(str[1]));
				size++;
				back = Integer.parseInt(str[1]);
			}else if(str[0].equals("front")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					
					System.out.println(q.peek());
				}
			}else if(str[0].equals("back")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(back);
					
				}
			}else if(str[0].equals("pop")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(q.poll());
					size--;
				}
			}else if(str[0].equals("size")) {
				System.out.println(size);
			}else if(str[0].equals("empty")) {
				if(q.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
			
		}
		
	}

}