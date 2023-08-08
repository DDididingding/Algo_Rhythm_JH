import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int three = 0;
		int total = 0;
		boolean done = false;
		
		while(N>=0) {
			if(N%5 == 0) {
				total = N/5;
				done = true;
				break;
			}else {
				N -=3;
				three++;
			}
			
		}
		
		if(done) {
			total += three;
			System.out.println(total);
		}else {
			System.out.println(-1);
		}
		
		
		
	}

}