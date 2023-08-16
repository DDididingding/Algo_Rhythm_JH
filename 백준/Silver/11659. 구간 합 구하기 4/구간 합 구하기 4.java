import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			if(i == 0) {
				nums[i] = Integer.parseInt(str[i]);
			}else {
				nums[i] = nums[i-1]+Integer.parseInt(str[i]);
			}
			
		}
		
		for(int m = 0; m<M; m++) {
			str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0])-1;
			int end = Integer.parseInt(str[1])-1;
			
			int sum =0;
			if(start == 0) {
				sum = nums[end];
			}else {
				sum = nums[end] - nums[start-1];
			}
			
			
			sb.append(sum);
			sb.append("\n");
			
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

}