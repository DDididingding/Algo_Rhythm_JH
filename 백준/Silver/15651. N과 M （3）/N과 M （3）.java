import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static boolean[] isUsed = new boolean[N];
	static int[] result = new int[M];
	static StringBuilder SB;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		isUsed = new boolean[N];
        result = new int[M];
        SB = new StringBuilder();
        
		NM(0);
		System.out.println(SB);
	}
	
	static void NM(int cnt) {
		
		if(cnt == M) {
			for(int m = 0; m<cnt;m++) {
				SB.append(result[m]);
//				System.out.print(result[m]);
				if(m < M-1) SB.append(' ');	
			}
			SB.append('\n');
			return;
		}
		for(int i = 0; i <N; i ++) {
			if(isUsed[i] == false) {
				result[cnt] = i+1;
				if(cnt+1 == M) {
					isUsed[i] = true;
				}
				NM(cnt+1);
				isUsed[i] = false;
			}
			
			
		}
		
		
		
	}

}