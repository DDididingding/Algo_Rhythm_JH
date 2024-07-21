import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        ArrayList<int[]> triangle = new ArrayList<>();
        for(int i = 1; i<= N; i++){
            str = br.readLine().split(" ");
            int[] now = new int[i];
            for(int j = 0; j < str.length; j++){
                now[j] = Integer.parseInt(str[j]);
            }
            triangle.add(now);
        }

        for(int i = 1; i < N; i++){
            int[] now = triangle.get(i);
            int[] before = triangle.get(i-1);

            now[0] += before[0];
            for(int j = 1; j<i; j++){
                now[j] = Math.max(now[j]+before[j-1], now[j]+before[j]);
            }
            now[i] += before[i-1];
        }

        int[] last = triangle.get(N-1);
        Arrays.sort(last);

        System.out.println(last[N-1]);

    }
}