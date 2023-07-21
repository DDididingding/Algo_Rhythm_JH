

import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//Scanner : 토큰단위로 끊음
		//토큰 : 공백(스페이스바, 엔터로 분덜된곳
		int T = sc.nextInt(); // 토큰을 정수로 바꿔서 가져옴
		for (int tc = 1;  tc<=T; tc++) {
			int sum = 0;
			for(int i =0; i<10; i++) {
				int num = sc.nextInt();
				if(num%2 ==1) {
					sum += num;
				}
			}
			System.out.println("#"+tc+" "+sum);
			
		}
		
	}
	
}
