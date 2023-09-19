import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			
			str = br.readLine().split("");
			int rotate = N/4;
			
//			String first = "";
//			String second = "";
//			String third = "";
//			String fourth = "";
			Set<Integer> set = new HashSet<>();
			List<Integer> nums;
			for(int r = 0; r<rotate; r++) {
				String first = "";
				String second = "";
				String third = "";
				String fourth = "";
				for(int i = 0; i<N/4; i++) {
					first += str[i+r];
				}
				for(int i = N/4; i<N/4*2; i++) {
					second += str[i+r];
				}
				for(int i = N/4*2; i<N/4*3; i++) {
					third += str[i+r];
				}
				for(int i = N/4*3; i<N; i++) {
					if(i+r>=N) {
						fourth += str[i+r-N];
					}else {
						fourth += str[i+r];	
					}
				}
				
				set.add(Integer.parseInt(first,16));
				set.add(Integer.parseInt(second,16));
				set.add(Integer.parseInt(third,16));
				set.add(Integer.parseInt(fourth,16));
			
			}
			nums = new ArrayList<Integer>(set);
			Collections.sort(nums,Collections.reverseOrder());
			System.out.println("#"+t+" "+nums.get(M-1));
		}
		
	}
}