import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static Long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        long max = 0;
        long min = 0;

        String[] st = br.readLine().split(" ");
        trees = new Long[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st[i]);
            if (max < trees[i]) {
                max = trees[i];
            }
        }

        // 내림차순 정렬
        Arrays.sort(trees, (a, b) -> b.compareTo(a));

        long answer = 0;

        while (min <= max) {
            long mid = (max + min) / 2;
            if (canCut(mid)) {
                answer = mid; // 현재 높이로 자를 수 있다면, 그 높이를 답으로 저장
                min = mid + 1; // 더 높은 높이도 가능한지 확인
            } else {
                max = mid - 1; // 현재 높이로 자를 수 없다면, 더 낮은 높이로 시도
            }
        }

        System.out.println(answer);
    }

    public static boolean canCut(long height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > height) { // 나무의 높이가 절단 높이보다 크다면
                sum += trees[i] - height; // 자른 나무 길이를 합산
            }
            if (sum >= M) { // 목표 길이만큼 자른 경우
                return true; // 자를 수 있음
            }
        }
        return sum >= M; // 최종적으로 목표 길이를 만족하는지 확인
    }
}