import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		long n = Integer.parseInt(str[0]);
		int r = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		
		long N = (long) Math.pow(2, n);
		

		ZZZ(0,0,N,0, r,c);
		
	
		
	}
	
	
	static void ZZZ(long y,long x, long N, long init, long r, long c) {
		if(N == 2) {
			if(y == r && x == c) {
				System.out.println(init);
			}else if(y == r && x+1 == c) {
				System.out.println(init+1);
			}else if(y+1 == r && x == c) {
				System.out.println(init+2);
			}else if(y+1 == r && x+1 == c) {
				System.out.println(init+3);
			}
		}else {
			N = N/2;
			if(r>=y+N) {
				if(c>=x+N) {
					ZZZ(y+N, x+N, N, (init+3)*4,r,c);
				}else {
					ZZZ(y+N, x, N, (init+2)*4,r,c);
				}
			}else {
				if(c>=x+N) {
					ZZZ(y, x+N, N, (init+1)*4,r,c);
				}else {
					ZZZ(y, x, N, init*4,r,c);
				}
			}
			
			

			
			

			
			
		}
	}

}