import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] tree;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new String[N][2*N-1];
		for(int i = 0; i <N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				tree[i][j] = " ";
			}
		}//별 찍을 배열 초기화
		
		
		treeStar(0,0,N,2*N-1);
		
		for(int i = 0; i <N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				sb.append(tree[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static void treeStar(int y, int x, int ud, int rl) {
		
		if(ud == 3) {
			
			tree[y][x+2] = "*";
			tree[y+1][x+1] = "*"; tree[y+1][x+3] = "*";
			for(int i = 0; i< 5; i++) {
				tree[y+2][x+i] = "*";
			}
		}else {
			ud = ud/2;
			int rlU = (rl-1)/4;
			int rlD = (rl+1)/2;
			rl = (rl-1)/2;
			
			//위
			treeStar(y,x+rlU+1,ud,rl);
			
			//아래
			treeStar(y+ud,x,ud,rl);
			treeStar(y+ud,x+rlD,ud,rl);
			
		}
		
		
	}
	
}