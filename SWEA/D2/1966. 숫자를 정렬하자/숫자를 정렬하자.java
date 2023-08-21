import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			String str[] = br.readLine().split(" ");
			int[] nums = new int[N];
			for(int i = 0; i <N; i++) {
				nums[i] = Integer.parseInt(str[i]);
			} // 리스트 입력
			int j = 0;
			for(int i = 1; i<N; i++) {
				int key = nums[i];
				for(j = i-1; j>=0 && key<= nums[j]; j--) {
					nums[j+1] = nums[j];
				}
				
				nums[++j] = key;
				
			}
			
			for(int i = 0; i<N; i++) {
				sb.append(nums[i]+" ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println("#"+t+" "+sb);
			sb.setLength(0);

			
		}
		
		
	}

}