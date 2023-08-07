import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {// 테스트 케이스 10개

			int N = Integer.parseInt(br.readLine());
			String[] strBuilding = new String[N];
			strBuilding = br.readLine().split(" ");
			int[] building = new int[N];
			for (int n = 0; n < N; n++) {
				building[n] = Integer.parseInt(strBuilding[n]);
			} // 값 입력받기

			int cnt = 0;// 조망권이 확보된 집 수 카운트

			for (int i = 2; i < N - 2; i++) { // 빌딩 탐색
				int I = building[i];

				while (true) {
					if (I > building[i - 1] && I > building[i - 2]) { // 최고층 왼쪽비교
						if (I > building[i + 1] && I > building[i + 2]) {// 최고층 오른쪽 비교
							cnt++;
							I--; // 한층 아래 탐색
						} else
							break;
					} else
						break;
				}

			}
			
			System.out.println("#"+t+" "+cnt);

		}
	}

}
