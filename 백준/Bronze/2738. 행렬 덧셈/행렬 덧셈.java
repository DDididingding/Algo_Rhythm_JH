import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		for(int n = 0; n <N; n++) {
			str = br.readLine().split(" ");
			for(int m = 0 ; m<M; m++) {
				A[n][m] = Integer.parseInt(str[m]);
			}
		}
		
		for(int n = 0; n <N; n++) {
			str = br.readLine().split(" ");
			for(int m = 0 ; m<M; m++) {
				B[n][m] = Integer.parseInt(str[m]);
			}
		}
		
		for(int n = 0; n <N; n++) {
			for(int m = 0 ; m<M; m++) {
				sb.append(A[n][m] + B[n][m]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
		
		
	}

}