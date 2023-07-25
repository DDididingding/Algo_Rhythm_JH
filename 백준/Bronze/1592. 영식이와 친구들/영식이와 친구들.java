
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int idx = 0;
		int[] friends = new int[N];
		int times = 0;
		
		boolean go = true;
		while(go) {
			
			if (friends[idx]%2 == 1) { //공을 받은 횟수가 홀수면
				idx += L; //시계방향으로 L번째 있는 사람에게 공을 줌
				if( idx > N-1 ) idx -= N; // L번째 사람이 인덱스 밖에 있으면 안으로
				
				friends[idx] += 1; // 공을 받은 횟수 추가
				
				if(friends[idx] == M) go = false; //공 M번 받았으면 그만
				
			}else { // 공을 받은 횟수가 짝수면
				idx -= L;
				if( idx < 0 ) idx += N;
				
				friends[idx] += 1;
				
				if(friends[idx] == M) go = false;
			}
			
			times ++; // 총 공을 받은 횟수 카운트
			
			
		
		}
		
		System.out.println(times-1);
		
	}
}
