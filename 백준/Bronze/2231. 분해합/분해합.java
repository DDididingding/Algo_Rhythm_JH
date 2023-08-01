import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		boolean a = true;
		for(int i = 1; i < N; i++) {
			sum = i; //분해합을 위해선 자기 자신을 먼저 더해야함
			int b = i;
			while(true) {
				
				sum += b%10; //1의 자리 숫자를 sum에 더하고
				if (b < 10) break; // 애초에 한자리수였으면 빠져나오기
				b = b/10; // 1의자리수 제거
			}
			
			if(sum == N) {
				System.out.println(i);
				a = false;// 생성자 찾았으면 0을 출력 안해야하니까
				break;// 찾으면 for문 탈출
			}
		}
		
		if(a) System.out.println(0); // 생성자 못찾아서 a가 true로 나오면 0 출력
		
	}

}
