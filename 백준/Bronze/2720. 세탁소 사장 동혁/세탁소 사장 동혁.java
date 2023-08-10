import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			int change = Integer.parseInt(br.readLine());
			int constant =change;
			int Q = 0;//25
			int D = 0;//10
			int N = 0;//5
			int P = 0;//1
			int Min = 1000;
			int cnt = 0;
			
			int minQ = 0;//25
			int minD = 0;//10
			int minN = 0;//5
			int minP = 0;//1
			
			
			while(true) {
				if(change<0)break;
				D=0;
				N=0;
				P=0;
				
				
				D += change /10;
				change = change - ((change/10) * 10);
				
				N += change / 5;
				change = change - ((change/5) * 5);
				
				P += change;
				
				cnt = Q+D+N+P;
				
				if(cnt <Min) {
					Min = cnt;
					minQ = Q;
					minD = D;
					minN = N;
					minP = P;
				}
				
				cnt = 0;
				constant -= 25;
				change = constant;
				

				Q++;
				
			}
			
			System.out.printf("%d %d %d %d\n", Q-1,D,N,P);
		}
	}

}