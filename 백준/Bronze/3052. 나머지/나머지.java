import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		for(int n = 0; n<10; n++) {
			int A = Integer.parseInt(br.readLine());
			arr[n] = A%42;
		}
		arr = Arrays.stream(arr).distinct().toArray();
		System.out.println(arr.length);
		
	}

}