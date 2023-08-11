import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		fac(1,N,1);
	}
	
	static void fac(int result, int N, int start) {
		if(start == N+1) {
			System.out.println(result);
		}else {
			result *=start;
			start++;
			fac(result, N, start);
		}
		
		
	}

}