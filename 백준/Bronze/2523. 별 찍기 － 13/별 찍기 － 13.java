import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		
		cnt = 1;
		for(int i = 0; i<N; i++) {

			for(int j = 0; j<cnt; j++) {
				sb.append("*");
			}
			sb.append('\n');
			cnt++;
		}
		
		cnt = N-1;
		for(int i = N; i<2*N-1; i++) {
			
			for(int j = 0; j<cnt; j++) {
				sb.append("*");
				
			}
			sb.append('\n');
			cnt--;
		}
		
		
		System.out.println(sb);
		
	}

}