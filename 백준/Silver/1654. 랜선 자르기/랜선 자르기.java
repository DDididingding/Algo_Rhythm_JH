import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		long K = Long.parseLong(str[0]);
		long N = Long.parseLong(str[1]);
		long[] lans = new long[(int) K];

		long max = 0;
		long min = 0;
		for (int i = 0; i < K; i++) {
			lans[i] = Long.parseLong(br.readLine());
			if (max < lans[i])
				max = lans[i];
		}

		long pointer = max; // 최대값부터 탐색
		long maxlen = 0;

		while (max >= min) { // 최대 최소가 다르면(구간의 길이가 1이상이면) 실행
			long cnt = 0; // 카운터 초기화

			for (int i = 0; i < K; i++) {
				cnt += lans[i] / pointer; // 현재 지정된 길이로 잘라서 개수 카운트
			}

			if (cnt >= N) { // 원하는 개수보다 많이 나오면
				min = pointer + 1; // 더 큰 길이로 자르기 위해서 포인터를 구간 왼쪽 끝으로 설정
				if (maxlen < pointer)
					maxlen = pointer; // 조건을 만족했던 최대 길이보다 현재 길이가 더 크면 갱신
				pointer = (min + max) / 2; // 구간 가운데 값을 포인터로 설정
			} else if (cnt < N) { // 원하는 개수보다 적게 나오면
				max = pointer - 1; // 더 작은 길이로 자르기 위해서 포인터를 구간 오른쪽 끝으로 설정
				pointer = (min + max) / 2;// 구간 가운데 값을 포인터로 설정
			}

		}

		System.out.println(maxlen);

	}

}