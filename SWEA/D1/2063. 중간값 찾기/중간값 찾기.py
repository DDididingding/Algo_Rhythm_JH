import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");
		int[] nums = new int[N]; //입력받을 배열
		int[] result = new int[N]; //결과 반환 배열
		
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st[i]); //숫자들 입력받기
		}
		
		int max_value = 0;
		for(int i = 0; i<N; i++) {
			if(nums[i]>max_value) max_value = nums[i]; //최댓값을 찾아서
		}
		
		int[] Counter = new int[max_value+1]; //최대값보다 하나 더 긴 배열 만들기
		for(int i = 0; i<N; i++) {
			Counter[nums[i]]++; //배열의 인덱스와 같은 값을 가진 수의 개수 카운트
		}
		
		
		for(int i = 1; i<max_value+1; i++) {
			Counter[i] = Counter[i-1]+Counter[i]; //누적 합 구하기
		}
//		System.out.println(Arrays.toString(Counter));
		
		for(int i = 0; i<N; i++) {
			result[--Counter[nums[i]]] = nums[i];
			
		}
		
		
//		System.out.println(Arrays.toString(result));
		
		System.out.println(result[(N-1)/2]);
		
	}

}