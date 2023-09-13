import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 1; n<= 9 ; n++) {
			sb.append(N+" * "+n+" = "+(N*n));
			sb.append("\n");
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
}