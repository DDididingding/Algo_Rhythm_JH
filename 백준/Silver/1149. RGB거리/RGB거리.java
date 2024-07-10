import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        int[][] dp = new int[N][3];
        int[][] RGB = new int[N][3];

        for(int n = 0 ; n < N; n++){
            String[] str = br.readLine().split(" ");
            for(int i = 0; i < 3; i++){
                RGB[n][i] = Integer.parseInt(str[i]);
            }
        }

        // 첫 번째 집의 비용 초기화
        for (int i = 0; i < 3; i++) {
            dp[0][i] = RGB[0][i];
        }

        // 두 번째 집부터의 비용 계산
        for (int n = 1; n < N; n++) {
            dp[n][0] = Math.min(dp[n-1][1], dp[n-1][2]) + RGB[n][0];
            dp[n][1] = Math.min(dp[n-1][0], dp[n-1][2]) + RGB[n][1];
            dp[n][2] = Math.min(dp[n-1][0], dp[n-1][1]) + RGB[n][2];
        }

        // 마지막 집에서의 최소 비용 구하기
        int result = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
        System.out.println(result);

    }
}