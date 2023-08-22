import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			LinkedList<String> code = new LinkedList<String>();
			
			for(int i = 0; i<N; i++) {
				code.add(str[i]);
			}
			
			int O = Integer.parseInt(br.readLine());
			str = br.readLine().split(" ");
			
			for(int i = 0; i<str.length; i++) {
				if(str[i].equals("I")) {
					int idx = Integer.parseInt(str[++i]);
					int cnt = Integer.parseInt(str[++i]);
					for(int j = 0; j< cnt; j++) {
						if(idx<11) {
							code.add(idx++, str[++i]);
						}					
					}
					
				}
			}
			sb.append("#"+t+" ");
			
			for(int i = 0; i<10; i++) {
				sb.append(code.get(i)+" ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println(sb);
			
			sb.setLength(0);
		}
		
		
		
	}

}