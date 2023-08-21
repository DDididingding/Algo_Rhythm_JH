import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			
			int[] bbang = new int [11112];
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int K = Integer.parseInt(str[2]);
			str = br.readLine().split(" ");
			int[] customer = new int[N];
			for(int i = 0; i < N; i++) {
				customer[i] = Integer.parseInt(str[i]);
			}
			//손님 온 시간에 -1
			//붕어빵 나오는 시간에 붕어빵개수 추가
			//배열 누적합
			//-1인 요소가 있으면 impossible
			int time = 1;
			while(M*time<=11111) {
				bbang[M*time] += K;
				time++;
			}

			for(int num : customer) {
				bbang[num]--;
			}
			boolean possible = true;
			if(bbang[0] <0) {
				possible = false;
			}
			for(int i =1; i<=11111; i++) {
				bbang[i] = bbang[i-1]+bbang[i];
				if(bbang[i]<0) {
					possible = false;
					break;
				}
			}
			if(possible) {
				System.out.println("#"+t+" Possible");
			}else {
				System.out.println("#"+t+" Impossible");
			}
			
			
		}
		
	}

}