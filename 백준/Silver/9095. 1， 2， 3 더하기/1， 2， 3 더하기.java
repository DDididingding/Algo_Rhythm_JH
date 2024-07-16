import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }




    }
}