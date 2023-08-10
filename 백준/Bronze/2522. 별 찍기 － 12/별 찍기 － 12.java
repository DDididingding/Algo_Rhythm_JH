import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		String[][] Star = new String[2*N-1][N];
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i<2*N-1; i++) {
			for(int j = 0; j<N; j++) {
				Star[i][j] = " ";
			}
			
		}
		
		cnt = 1;
		for(int i = 0; i<N; i++) {

			for(int j = N-1; j>N-1 -cnt; j--) {
				Star[i][j] = "*";
			}
			cnt++;
		}
		
		cnt = N-1;
		for(int i = N; i<2*N-1; i++) {
			
			for(int j = N-1; j>N-1 -cnt; j--) {
				Star[i][j] = "*";
				
			}
			cnt--;
		}
		
		for(int i = 0; i<2*N-1; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(Star[i][j]);
			}
			sb.append('\n');
			
		}
		
		System.out.println(sb);
		
	}

}