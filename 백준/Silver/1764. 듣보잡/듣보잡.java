import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        HashSet<String> set = new HashSet<>();

        for(int n = 0; n < N; n++){
            set.add(br.readLine());
        }

        TreeSet<String> answer = new TreeSet<>();

        for(int m = 0; m < M; m++){
            String now = br.readLine();
            if(set.contains(now)){
                answer.add(now);
            }
        }

        System.out.println(answer.size());

        for(String DBJ : answer){
            System.out.println(DBJ);
        }
    }
}