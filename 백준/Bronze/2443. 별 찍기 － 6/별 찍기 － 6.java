
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int cnt1 = 2*N-1;
		for (int i = 0; i<N; i++) { //줄 개수
			
			for (int j = 0; j<cnt; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j<cnt1; j ++) {
				System.out.print("*");
			}
			
			cnt++;
			cnt1 -= 2;
			System.out.println();
		}
		
		
	}

}