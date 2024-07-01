import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int steps;
    static int[] scores;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        steps = Integer.parseInt(br.readLine());
        scores = new int[steps + 1];
        dp = new int[steps + 1];

        for (int i = 1; i <= steps; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if (steps == 0) {
            System.out.println(0);
            return;
        }

        if (steps == 1) {
            System.out.println(scores[1]);
            return;
        }

        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];

        for (int i = 3; i <= steps; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }

        System.out.println(dp[steps]);
    }
}