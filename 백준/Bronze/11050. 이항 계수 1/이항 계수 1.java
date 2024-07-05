import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int R = K;

        int head = 1;
        int tail = 1;
        for(int i = N; R >0; R--, i--){
            head = head*i;
        }
        for(int i = 1; i<=K; i++){
            tail = tail*i;
        }

        System.out.println(head/tail);

    }
}