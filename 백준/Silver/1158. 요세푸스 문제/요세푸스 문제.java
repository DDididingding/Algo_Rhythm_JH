import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int[] ppl = new int[N];
		sb.append("<");
		int total = 0;
		int cnt = 0;
		int idx = 1;
		if(N == 1) {
			sb.append(1);
		}else {
			while(total < N) {
				if(ppl[idx]==0) {
					cnt++;
					if(cnt == K) {
						if(idx == 0) {
							sb.append(N+", ");
						}else {
							sb.append(idx+", ");
						}

						ppl[idx] = 1;
						cnt = 0;
						total++;
					}
					idx++;
					idx = idx%N;
				}else {
					idx++;
					idx = idx%N;
				}
				
				
			}
				
			
			
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		sb.append(">");
		
		System.out.println(sb);
	}

}