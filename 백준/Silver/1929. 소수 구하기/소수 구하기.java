import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] list = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			list[i] = i;
		}
		
		list[1] = -1;
		
		for(int i = 2; i<=N; i++) {
			if(list[i] != -1) { //리스트 현재 값이 -1이 아니면
				int n = 2;
				while(i*n<=N) { //i*n이 최대값이하일 동안
					list[i*n] = -1; //i의 배수들을 모두 -1로 바꾼다.
					n++;
				}
			}
		}
		
		for(int i = M; i<=N; i++) {
			if(list[i] != -1) {
				System.out.println(list[i]);
			}
		}
		
	}
}