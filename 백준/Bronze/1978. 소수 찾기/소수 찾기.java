import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int nums[] = new int[N];
		int max = 0;
		
		for(int i = 0 ; i < N; i++) {
			nums[i] = sc.nextInt();
			if(max<nums[i]) max = nums[i];
		}
		
		
		int[] list = new int[max+1];
		
		for(int i = 1; i<=max; i++) {
			list[i] = i;
		}
		
		list[1] = -1;
		
		for(int i = 2; i<=max; i++) {
			if(list[i] != -1) { //리스트 현재 값이 -1이 아니면
				int n = 2;
				while(i*n<=max) { //i*n이 최대값이하일 동안
					list[i*n] = -1; //i의 배수들을 모두 -1로 바꾼다.
					n++;
				}
			}
		}
		
		int cnt = 0 ;
		for(int i = 0; i<N; i++) {
			if(list[nums[i]] != -1) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}