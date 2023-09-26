import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] numsToFind;
	static int[] numList;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");

		numList = new int[N];

		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(str[i]);
		} // input nums to find

		M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");

		numsToFind = new int[M];

		for (int i = 0; i < M; i++) {
			numsToFind[i] = Integer.parseInt(str[i]);
		} // input number list

		Arrays.sort(numList); // sort numList to use binary search

		for (int i = 0; i < M; i++) {
			isThere(numsToFind[i]); // do binary search method for each elements in numsToFind list
		}

	}

	private static void isThere(int i) {
		int left = 0;
		int right = N - 1;
		int pointer = (left + right) / 2;
		int indicator = 0;

		while (left <= right) {
			if (numList[pointer] < i) { // if digit at pointer is less than i, we have to reset search at large section
				// so pointer should be left value
				left = pointer + 1;
				pointer = (left + right) / 2; // reset pointer

			} else if (numList[pointer] > i) {// if digit at pointer is bigger than i, we have to reset search at left
												// section
				right = pointer - 1; // so pointer should be a right value
				pointer = (left + right) / 2; // reset pointer
			} else if (numList[pointer] == i) { // if digit at pointer is match,
				indicator = 1; // set indicator as 1;
				break; // break loop
			}
		}

		System.out.println(indicator); // if we find right value, indicator will have 1.

	}
}