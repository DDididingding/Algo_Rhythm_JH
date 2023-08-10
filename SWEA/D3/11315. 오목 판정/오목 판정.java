import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static String[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());


		for (int t = 1; t <= T; t++) {
			boolean Omok = false;
			int N = Integer.parseInt(br.readLine());

			board = new String[N][N];

			for (int i = 0; i < N; i++) {
				board[i] = br.readLine().split(""); // 오목 판 입력받기
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//						System.out.print(board[i][j]);
//					}
//						System.out.println();
//				}
				

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j].equals("o")) { // 전수 조사하다가 o를 만나면
						Dol(i, j, N); // 돌 함수 실행

						if (Dol(i, j, N)) { // 돌이 트루로 나오면
							System.out.printf("#%d YES\n", t);
							Omok = true;
							break; // 포문 닫기
						}
					}

				}
				if (Omok)
					break; // 오목이 트루면 포문 닫기
			}

			if (!Omok)
				System.out.printf("#%d NO\n", t); // 오목이 false면 이거 출력

		}

	}

	static boolean Dol(int y, int x, int N) {

		int[][] del = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } // 8방향
		};

		for (int d = 0; d <= 7; d++) { // 8방향에 대해서
			int cnt = 1;
			int Y = del[d][0];
			int X = del[d][1];
			for (int i = 1; i <= 4; i++) { // 4번씩 탐색. 왜냐면 내가 있는 자리는 o에서 시작을 했기 때문.

				if (y + Y * i > N - 1 || y + Y * i < 0 || x + X * i > N - 1 || x + X * i < 0) { // 만약 한개라도 배열을 벗어나면
					break; // 아무것도 안함
				} else {
					if (board[y + Y * i][x + X * i].equals("o")) {
						cnt++; // 배열을 안벗어나고 칸이 o 면 cnt 하나 올려주기
					}else {
						break;
					}
						
				}

			}

			if (cnt == 5) {
				return true;
			}
		}

		return false; // true를 반환하지 못하고 나오면 false 반환
	}

}