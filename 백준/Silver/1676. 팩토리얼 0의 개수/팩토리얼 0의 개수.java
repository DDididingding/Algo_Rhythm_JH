import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = 5;
		int cnt = 0;
		while(N>=a) {
			cnt += N/a;
			a = a*5;
		}
		
		System.out.println(cnt);
		
	}
}