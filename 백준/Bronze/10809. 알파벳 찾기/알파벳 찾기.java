import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);
		
		for(int i = 0; i<S.length(); i++) {
			if(alpha[S.charAt(i)-'a']!=-1 && alpha[S.charAt(i)-'a'] < i) {
				continue;
			}
			 alpha[S.charAt(i)-'a'] = i;
		}
		
		for(int i = 0; i<26; i++) {
			sb.append(alpha[i]+" ");
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

}