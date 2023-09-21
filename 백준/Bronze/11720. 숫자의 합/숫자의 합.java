import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(str[i]);
		}

		System.out.println(sum);
	}
}