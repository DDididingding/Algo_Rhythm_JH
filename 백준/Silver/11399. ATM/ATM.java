import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] timeList = new int[N];
		
		for(int i = 0; i<N; i++) {
			timeList[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(timeList);
		
		for(int i = 0; i<N-1; i++) {
			timeList[i+1] = timeList[i]+timeList[i+1];
		}
		
		int total = 0;
		for(int i = 0; i<N; i++) {
			total += timeList[i];
		}
		
		System.out.println(total);
		
		
	}
}