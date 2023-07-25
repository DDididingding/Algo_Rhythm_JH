
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] sheet = br.readLine().split("");
		
		int p = 1;
		
		for(int i = 0; i <N; i++) {
			if (sheet[i].equals("S")) {
				p++;
			}else if (sheet[i].equals("L")) {
				i++;
				p++;
			}
		}
		
		if(p>= N) System.out.println(N);
		if(N > p) System.out.println(p);

	}
}
