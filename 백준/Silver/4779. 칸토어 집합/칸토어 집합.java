import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String[] JJic;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			int n = (int)Math.pow(3, N);
			JJic = new String[n];
			for(int i = 0; i<n; i++) {
				JJic[i] = "-";
			}
			
			if(n==1) {
				System.out.println("-");
			}else {
				kantor(0,n);
				for(int i = 0; i<n; i++) {
					sb.append(JJic[i]);
				}
				
				System.out.println(sb);
				sb.setLength(0);
			}
			
		}
		
	}
	static void kantor(int start, int n) {
		if(n == 3) {
			JJic[start+1] = " ";
		}else {
			n = n/3;
			for(int i = 0; i<n; i++) {
				JJic[start+n+i] = " ";
			}
			kantor(start, n);
			kantor(start+(2*n), n);
			
		}
		
		
		
	}

}