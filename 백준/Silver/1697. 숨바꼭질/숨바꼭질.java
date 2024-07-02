import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        System.out.println(find(N, K));
    }

    public static Integer find(int N, int K){
        int answer = -1;
        boolean[] visited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N,0});
        visited[N] = true;


        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int sec = cur[1];

            if(now == K){
                answer = sec;
                break;
            }

            if(now-1 >=0 && !visited[now-1]) {
                q.offer(new int[]{now-1, sec+1});
                visited[now-1] = true;
            }
            if(now+1 <= 100000 && !visited[now+1]) {
                q.offer(new int[]{now+1, sec+1});
                visited[now+1] = true;
            }
            if(now*2 <= 100000 && !visited[now*2]) {
                q.offer(new int[]{now*2, sec+1});
                visited[now*2] = true;
            }

        }

        return answer;
    }
}