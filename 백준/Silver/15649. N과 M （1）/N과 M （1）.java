import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static boolean[] visited = new boolean[9];
	static int[] result = new int [9]; 
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = new String[2];
		NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
//		System.out.println(Arrays.toString(result));
		perm(0);
					
	}

	public static void perm(int cnt) {
		//탈출장치
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j<M; j++) {
//				System.out.print(result[j]);
				sb.append(result[j]);
//				if(j < M-1) System.out.print(" ");
				if(j < M-1) sb.append(' ');
			}
			System.out.println(sb.toString());
			return;
		}
			
		//무환동력
		for(int i = 1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i;
				perm(cnt+1); //!!!!!!!!!!!!!cnt++
				visited[i] = false;
			}
		}
		
	}
	
}