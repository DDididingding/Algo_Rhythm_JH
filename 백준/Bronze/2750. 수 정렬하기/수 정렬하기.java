import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min;
	static int minIdx;
	
	
	 public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for(int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(br.readLine());
		}
		
		
		int [] sortedList = sort(0,N,nums);
		
		for(int i = 0; i < N; i++) {
			sb.append(sortedList[i]);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
		
	}
	 
	 static int[] sort(int start, int N, int[] nums) {
		 if(start == N) {
			 return nums;
		 }else {
			 min = nums[start];  // 최소값을 현재 위치 값으로 초기화
		        minIdx = start;
			 for(int i = start; i<N; i++) {
				 if(min > nums[i]) {
					 min = nums[i];
					 minIdx = i;
				 }
			 }
			 nums[minIdx] = nums[start];
			 nums[start] = min;
			 

			 sort(start+1, N, nums);
		 }
		 
		 
		 return nums;

	 }

}