import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String[] str = br.readLine().split("");
            System.out.print(str[0]);
            System.out.print(str[str.length-1]);
            System.out.println();
        }
    }
}