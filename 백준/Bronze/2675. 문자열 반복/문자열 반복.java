import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			String[] str = br.readLine().split(" ");
			
			int repeat = Integer.parseInt(str[0]);
			
			for(int i = 0 ; i<str[1].length(); i++) {
				for(int j = 0; j<repeat; j++) {
					sb.append(str[1].charAt(i));
				}
			}
			
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}