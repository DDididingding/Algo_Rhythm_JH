import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int total = 0;
		int side1 = 0;

		for(int i = 1; i <= Math.sqrt(n); i++) {
			side1 = i;
			int cnt = i;
			while(side1*cnt <= n) {
				total++;
				cnt++;
			}
		}
		
		System.out.println(total);
		
	}

}