import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");
			int[] height = new int[100];
			boolean print = false;//덤프가 미리 끝났는지 체크
			
			
			for(int i = 0; i < 100; i++) {
				height[i] = Integer.parseInt(st[i]);
			} //높이 정보 입력받기
			
			Arrays.sort(height); //높이 순으로 정렬
			
			for(int n = 0; n < N; n++) {
				if(height[0] == height[99]) { //최댓값과 최소값이 같으면 0 출력
					System.out.println("#"+t + " "+ 0);
					print = true;
					break;
				}else if(height[0]==height[98]) { //최소값이 끝에서 두번째 값과 같고, 
					if(height[99]-height[98] == 1) { //끝에서 두번째 값과 최대값의 차이가 1이면
						System.out.println("#"+t + " "+ 1);
						print = true;
						break;
					}
				}
				height[0] = height[0]+1;
				height[99] = height[99]-1; //최댓값에서 최솟값으로 덤프
				
				int M_idx = 99;
				while(true) {
					if(height[M_idx]<height[M_idx-1]) {
						int temp = height[M_idx];
						height[M_idx] = height[M_idx-1];
						height[M_idx-1] = temp;
						M_idx--;
					}else {
						break;
					}
				}// 혹시 최대값이 변했으면 다시 정렬
				
				int m_idx = 0;
				while(true) {
					if(height[m_idx]>height[m_idx+1]) {
						int temp = height[m_idx];
						height[m_idx] = height[m_idx+1];
						height[m_idx+1] = temp;
						m_idx++;
					}else {
						break;
					}
				}// 혹시 최소값이 변했으면 다시 정렬
				
				
			}
			
			
			if(!print) System.out.println("#"+t + " "+(height[99] - height[0]));
			
			
			
		}
	}
	
}