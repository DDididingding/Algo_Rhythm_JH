import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String[][] map;
	static String[][] switchmap;
	static int max_len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			String T = br.readLine();
			map = new String[100][100];
			switchmap = new String[100][100];
			max_len = 0;

			for (int i = 0; i < 100; i++) {
				map[i] = br.readLine().split(""); // 배열 입력받기
			}

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {//가로줄 검사
					int del = 0;
					while(true) {
						isPal(j, 99-del, map[i]);
						if(isPal(j, 99-del, map[i])) break;
						del++;
					}
				}
			}
			
			for(int i = 0; i < 100; i++) { //세로줄 검사 함수 만들기 귀찮으니까 배열을 행열전환
				for(int j = 0; j<100; j++) {
					switchmap[j][i] = map[i][j];
				}
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {//바뀐 행렬로 세로줄 검사
					int del = 0;
					while(true) {
						isPal(j, 99-del, switchmap[i]);
						if(isPal(j, 99-del, switchmap[i])) break;
						del++;
					}
				}
			}
			
			
			System.out.println("#"+t+" "+max_len);

		}
	}
	
	public static boolean isPal(int start, int end, String[] map) {
		int middle = (int)(start+end)/2;
		int temp = end;
		for(int i = start; i<=middle; i++) {
			if(map[i].equals(map[temp])) {
				temp--;
				if(i == middle) {
					if(max_len < end-start+1) max_len = end-start+1;
					return true;
				}
			}else {
				
				return false;
				
			}
		}
		return false;
		
	}

}