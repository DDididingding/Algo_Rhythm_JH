
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = new String[N];  //String으로 입력받아서
			str = br.readLine().split(" ");
			int[] price = new int[N];  
			for(int i = 0; i <N; i++) {
				price[i] = Integer.parseInt(str[i]); //정수형 변환해서 배열 입력받기
			}
			int max = price[N-1];
			long earning = 0;
			for(int i = N-1; i>=0; i--) {
				if(price[i] < max) {
					earning += max - price[i];
				}else if(price[i] >= max) {
					max = price[i];
				}
				
			}
			System.out.println("#"+t+" "+earning);
		}
	}
	
}
