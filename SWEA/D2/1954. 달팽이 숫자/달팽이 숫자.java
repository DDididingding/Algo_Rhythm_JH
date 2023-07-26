
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] snail = new int[N][N];
			
			boolean go = true;
			int ver = 0;
			int verN = N;
			int verS = -1;
			int hor = 0;
			int horN = N;
			int horS = -1;
			int num = 1;
			int dir = 1;
			
			while(go) {
				switch(dir) {
				case 1:
					if(hor == horN) {
						dir = 2;
						ver++;
						verS++;
						hor--;
						break;
					}
					if(num == N*N+1) {
						go = false;
						break;
					}
					snail[ver][hor++] = num++;
					break;
				case 2:
					if(ver == verN) {
						dir = 3;
						hor--;
						horN--;
						ver--;
						break;
					}
					if(num == N*N+1) {
						go = false;
						break;
					}
					snail[ver++][hor] = num++;
					break;
				case 3:
					if(hor == horS) {
						dir = 4;
						ver--;
						hor++;
						verN--;
						break;
					}
					if(num == N*N+1) {
						go = false;
						break;
					}
					snail[ver][hor--] = num++;
					break;
					
				case 4:
					if(ver == verS) {
						dir = 1;
						hor++;
						ver++;
						horS++;
						break;
					}
					if(num == N*N+1) {
						go = false;
						break;
					}
					snail[ver--][hor] = num++;
					break;
				}//switch문 끝
				
				
			}// while문 끝
			
			System.out.println("#"+t);
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					System.out.print(snail[i][j]);
					if(j != N-1) {
						System.out.print(" ");
					}
				}
				System.out.println();
				
			}
			
		}//이게 한 번의 케이스
	}
}
