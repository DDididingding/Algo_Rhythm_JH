import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] Numcnt = new int[10];
		long num = 1;
		for(int i = 0; i<3; i++) {
			
			num *= Integer.parseInt(br.readLine());

		}
		
		String str = Long.toString(num);
		
		for(int i = 0; i<str.length(); i++) {
			Numcnt[ str.charAt(i)-'0']++;
		}

		for(int i = 0; i<10; i++) {
			System.out.println(Numcnt[i]);
		}
		

		
		
	}

}