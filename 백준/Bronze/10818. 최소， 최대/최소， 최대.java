
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			int temp = Integer.parseInt(str[i]);
			if(temp<min) min = temp;
			if(temp>max) max = temp;
		}
		
		System.out.println(min + " " +max);
	}

}