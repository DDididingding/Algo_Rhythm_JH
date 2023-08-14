import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			
			String trash = br.readLine();
			String tofind = br.readLine(); //찾을 문자열
			String sentence = br.readLine(); //전체 문자열
			
			int cnt = 0; //매치되는 개수
			
			for(int i = 0; i <= sentence.length()-tofind.length() ; i++) {
				if(sentence.charAt(i) == tofind.charAt(0)) { // 문장의 i번 글자와 내가 찾아야하는 첫번째 글자가 같으면
					for(int f = 1; f<tofind.length(); f++) { //다음 글자와 내가 찾는 문자열의 다음 글자를 비교
						if(sentence.charAt(i+f) != tofind.charAt(f)) {
							break;
						}
						if(f == tofind.length()-1) {
							cnt++;
						}
					}
					
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
	}
}