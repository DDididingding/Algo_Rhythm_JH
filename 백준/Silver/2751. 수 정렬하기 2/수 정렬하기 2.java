import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N  = Integer.parseInt(br.readLine());
		List<Integer> a = new ArrayList<>(); 
		
		for(int i = 0 ; i< N; i++) {
			a.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(a);
		
		for(int i = 0 ; i< N; i++) {
			sb.append(a.get(i)+"\n");
		}

		System.out.print(sb);
		
		
		
		
	}

}