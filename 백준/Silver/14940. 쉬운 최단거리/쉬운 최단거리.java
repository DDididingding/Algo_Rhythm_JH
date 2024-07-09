import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int n = 0; n < N; n++){
            str = br.readLine().split(" ");
            for(int m = 0; m < M; m++){
                map[n][m] = Integer.parseInt(str[m]);
                if(map[n][m] == 0) visited[n][m] = true;
            }
        }

        loop:
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                if(map[n][m] == 2){
                    bfs(n, m);
                    break loop;
                }
            }
        }

        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                if(!visited[n][m]) map[n][m] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                sb.append(map[n][m]);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        System.out.println(sb);


    }

    public static void bfs(int n, int m){
        int[] dn = {-1, 1, 0, 0};
        int[] dm = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, m, 0});
        visited[n][m] = true;
        map[n][m] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curN = cur[0];
            int curM = cur[1];
            int distance = cur[2];

            for(int i = 0; i < 4; i++){
                int nextN = curN + dn[i];
                int nextM = curM + dm[i];

                if(nextN >=0 && nextN < N && nextM >=0 && nextM < M && !visited[nextN][nextM]){
                    q.offer(new int[]{nextN, nextM, distance+1});
                    map[nextN][nextM] = distance+1;
                    visited[nextN][nextM] = true;
                }
            }
        }
    }
}