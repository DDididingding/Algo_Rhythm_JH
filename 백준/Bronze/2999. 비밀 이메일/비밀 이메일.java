import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		int N = code.length();
		int R = 0;
		int C = 0;
		for(int i = N-1; i>=1; i--) {
			if(N%i == 0) {
				R = i;
				C = N/R;
				if(R<=C)break;
			}
		}
		
		
		String[][] grid = new String[C][R];
		int idx = 0;
		for(int i = 0; i <C; i++) {
			for(int j = 0; j <R; j++) {
				
				grid[i][j] = String.valueOf(code.charAt(idx++));
			}
			
		}
		
		for(int j = 0; j <R; j++) {
			for(int i = 0; i <C; i++) {
				System.out.print(grid[i][j]);
			}
		}
		
		
	}
}
