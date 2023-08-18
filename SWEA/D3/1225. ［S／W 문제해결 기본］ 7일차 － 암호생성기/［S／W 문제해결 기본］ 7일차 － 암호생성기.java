import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] nums = new int[8];
			for(int i = 0; i<8; i++) {
				nums[i] = Integer.parseInt(str[i]); //숫자 배열 입력받기
			}
			
			int minus = 1;
			int idx = 0;
			while(true) {
				nums[idx++] -= minus++;
				
				if(nums[idx-1] <= 0) {
					nums[idx-1] = 0;
					break;
				}
				if(minus == 6) minus = 1;	
				if(idx == 8) idx = 0;
			}
			
			int cnt = 1;
			while(cnt <= 8){
				sb.append(nums[idx++]);
				sb.append(" ");
				if(idx == 8) idx = 0;
				cnt++;
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println("#" + t+" "+ sb);
			sb.setLength(0);
			
		}
		
	}
	

}