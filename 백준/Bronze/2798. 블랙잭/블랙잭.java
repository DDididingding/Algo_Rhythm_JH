
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int closest = 0; // 가장 가까운 값 저장
		int sum = 0; // 합 저장
		
		int[] cards = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		
		for(int i =0; i<N; i++) { //카드 목록 저장
			cards[i] = Integer.parseInt(st1.nextToken());
		}
		
		
		//조합 식 작성
		for(int i = 0; i < N-2; i++) { //1번째 카드
			
			for (int j = i+1; j <N-1; j++) { //2번째 카드
				
				for (int k = j+1; k <N; k++) { // 3번째 카드
					sum = cards[i] + cards[j] + cards[k];
					
					if(M >= sum) {
						if(M-sum < M-closest) closest = sum; 
					}
					

				}
				
			}
			
		}
		
		System.out.println(closest);
		
			
	}

}
