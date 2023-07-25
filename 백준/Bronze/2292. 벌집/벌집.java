import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int step = 6;
		int cnt = 1;
		int N = Integer.parseInt(br.readLine());
		int a = 1;
		while(true) {
			
			if(N == 1) {
				break;
			}
			
			if(a < N && N <= a+ step) {
				cnt++;
				break;
			}
			cnt++;
			a = a+step;
			step += 6;
		}
		
		System.out.println(cnt);
		
	}
	
	
	
}
