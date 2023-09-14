import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		
		int H = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		if(M-45<0) {
			if(H-1<0) {
				H = 23;
			}else {
				H--;
			}
			M = M+60-45;
		}else {
			M -=45;
		}
		
		System.out.println(H+" "+M);
	}

}