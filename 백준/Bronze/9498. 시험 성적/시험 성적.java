import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		if (N >= 90) {
			System.out.println("A");
		} else if (90 > N && N >= 80) {
			System.out.println("B");
		} else if (80 > N && N >= 70) {
			System.out.println("C");
		} else if (70 > N && N >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

	}
}