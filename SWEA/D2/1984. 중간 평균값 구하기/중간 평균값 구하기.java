import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			String[] Nums = new String[10];
			Nums = br.readLine().split(" ");
			int[] nums = new int[10];
			for(int i = 0; i<10; i++) {
				nums[i] = Integer.parseInt(Nums[i]);
			}
			
			Arrays.sort(nums);
			float avg = 0;
			for(int i = 1; i<9; i++) {
				avg += nums[i];
			}
			avg = Math.round(avg/8);
			
			System.out.println("#"+t+" "+(int)avg);
		}
		
	}

}