import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			String[] str = br.readLine().split(" ");
			
			int H = Integer.parseInt(str[0]);
			int W = Integer.parseInt(str[1]);
			int N = Integer.parseInt(str[2]);
			
			
			int back = N/H+1;
			if (H ==1 ) back = N;
			
			int front = N%H;
			if(front == 0) {
				front = H;
				back = N/H;
			}
			sb.append(front);
			
			
			
			
			if(back/10<1) {
				sb.append(0);
			}
			sb.append(back);
			
			
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}