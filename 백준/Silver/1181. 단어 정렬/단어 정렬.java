import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		String[] str = set.toArray(new String[0]);
		Arrays.sort(str);
		Arrays.sort(str,new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return -(o2.length() - o1.length());
				}
		});
		
		for(int i = 0 ; i<str.length; i++) {
			System.out.println(str[i]);
		}
	}
}