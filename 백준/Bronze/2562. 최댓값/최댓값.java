import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = -1;
		int maxIdx = -1;
		for(int i = 0 ; i<9; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num>max) {
				max = num;
				maxIdx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(maxIdx);
	}
}