import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		if(N ==1) {
			System.out.println(1);
		}else {
			while (true) {
				q.poll();
				if (q.size() == 1) {
					System.out.println(q.poll());
					break;
				}
				q.offer(q.poll());
				
			}
		}
		

	}

}