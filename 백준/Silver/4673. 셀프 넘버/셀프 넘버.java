import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<>();
		int N = 1;
		StringBuilder sb = new StringBuilder();
		
		while(true) {

			digits.add(digit(N));
			if(digits.contains(N)) {
				
			}else {
				sb.append(N+"\n");
			}
			N++;

			if(N>10000) break;
		}
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.println(sb);
	}
	
	static int digit(int N) {
		int result = 0;
		int last = 0;
		result += N;
		while(N>0) {
			last = (int) N%10;
			result += last;
			N = (int) (N-last) /10;
		}
		
		return result;
		
	}

}