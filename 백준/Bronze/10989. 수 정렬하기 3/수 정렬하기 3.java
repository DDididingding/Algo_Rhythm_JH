import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		int max = 0;
		
		for(int n = 0; n<N; n++) {
			nums[n] = Integer.parseInt(br.readLine());
			if(max<= nums[n]) {
				max = nums[n]; //최댓값과 숫자리스트 저장
			}
		}
		
		int[] idx = new int[max+1]; //가장 큰 숫자보다 1개 더 큰 길이를 가진 배열 만들기
		
		for(int i = 0; i < N; i++) { // 배열의 인덱스 == 숫자 , 숫자의 개수를 세서 기록
			idx[nums[i]]++;
		}
		
		for (int i = 0; i<max; i++) { //마지막 인덱스는 제외.
			idx[i+1] = idx[i]+idx[i+1]; //리스트를 누적합이 되도록 변경
		}
		
		int[] result = new int[N];
		
		for(int i = N-1; i>=0; i--) { //가장 큰 값부터, 
			result[--idx[nums[i]]] = nums[i];
		}
		
		for(int i = 0; i<N ; i++) {
			sb.append(result[i]);
			sb.append("\n");
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		
		
	}

}