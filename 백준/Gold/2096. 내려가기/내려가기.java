import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] road = new int[N][3];

        for(int n = 0; n < N; n++){
            String[] str = br.readLine().split(" ");
            for(int i = 0; i < 3; i++){
                road[n][i] = Integer.parseInt(str[i]);
            }
        }

        minDp[0][0] = road[0][0];
        minDp[0][1] = road[0][1];
        minDp[0][2] = road[0][2];
        maxDp[0][0] = road[0][0];
        maxDp[0][1] = road[0][1];
        maxDp[0][2] = road[0][2];

        for(int i = 1; i < N; i++){
            minDp[i][0] = Math.min(minDp[i-1][0] + road[i][0], minDp[i-1][1] + road[i][0]);
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0] + road[i][1], minDp[i-1][1] + road[i][1]), minDp[i-1][2] + road[i][1]);
            minDp[i][2] = Math.min(minDp[i-1][1] + road[i][2], minDp[i-1][2] + road[i][2]);

            maxDp[i][0] = Math.max(maxDp[i-1][0] + road[i][0], maxDp[i-1][1] + road[i][0]);
            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0] + road[i][1], maxDp[i-1][1] + road[i][1]), maxDp[i-1][2] + road[i][1]);
            maxDp[i][2] = Math.max(maxDp[i-1][1] + road[i][2], maxDp[i-1][2] + road[i][2]);
        }

        int maxValue = Math.max(Math.max(maxDp[N-1][0], maxDp[N-1][1]), maxDp[N-1][2]);
        int minValue = Math.min(Math.min(minDp[N-1][0], minDp[N-1][1]), minDp[N-1][2]);

        System.out.println(maxValue);
        System.out.println(minValue);
    }
}