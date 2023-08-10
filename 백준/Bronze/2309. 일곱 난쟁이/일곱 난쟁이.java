import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] shorts = new int[9];
		int sum = 0;
		for(int i = 0; i <9; i++) {
			shorts[i] = Integer.parseInt(br.readLine());
			sum += shorts[i];
		}
		boolean stop = false;
		Arrays.sort(shorts);
		
		for(int i = 0; i<9; i++) {
			if(stop) break;
			for(int j = 0; j<9; j++) {
				if(stop) break;
				if(i!=j) {
					int temp = 0;
					temp = sum - shorts[i] - shorts[j];
					if(temp == 100) {
						for(int k = 0; k<9; k++) {
							if(k!=i&&k!=j) {
								System.out.println(shorts[k]);
								stop = true;
							}
						}
					}
				}
			}
		}
		
		
	}
	

}