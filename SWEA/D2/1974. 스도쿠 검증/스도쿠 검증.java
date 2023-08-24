import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] sdoku;
	static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sdoku = new int[9][9];
			boolean isRight = true;
			for (int i = 0; i < 9; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			for(int i = 0; i<9; i++) {
				if(!horCheck(i) || !verCheck(i)) {
					isRight = false;
					break;
				}
			}
			if(!boxCheck(0,0) || !boxCheck(0,3) || !boxCheck(0,6) || !boxCheck(3,0) || !boxCheck(3,3) || !boxCheck(3,6) || !boxCheck(6,0) || !boxCheck(6,3) || !boxCheck(6,6) ) {
				isRight = false;
			}

			if(isRight) {
				System.out.println("#"+t+" "+1);
			}else {
				System.out.println("#"+t+" "+0);
			}
		}

	}

	static boolean horCheck(int column) {
		check = new int[10];

		for (int i = 0; i < 9; i++) {
			check[sdoku[column][i]]++;
		}
		for (int i = 1; i <= 9; i++) {
			if (check[i] != 1)
				return false;
		}
		return true;
	}

	static boolean verCheck(int row) {
		check = new int[10];

		for (int i = 0; i < 9; i++) {
			check[sdoku[i][row]]++;
		}
		for (int i = 1; i <= 9; i++) {
			if (check[i] != 1)
				return false;
		}
		return true;
	}

	static boolean boxCheck(int y, int x) {
		check = new int[10];
		for(int i = y; i<y+3; i++) {
			for(int j = x; j<x+3; j++) {
				check[sdoku[i][j]]++;
			}
		}
		for (int i = 1; i <= 9; i++) {
			if (check[i] != 1)
				return false;
		}
		return true;
	}

}