import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String[] init = br.readLine().split(" ");
            M = Integer.parseInt(init[0]);
            N = Integer.parseInt(init[1]);
            int K = Integer.parseInt(init[2]);

            map = new int[M][N];

            for(int k = 0; k < K; k++) {
                String[] coordinate = br.readLine().split(" ");
                int x = Integer.parseInt(coordinate[0]);
                int y = Integer.parseInt(coordinate[1]);

                map[x][y] = 1;
            }

            int count = 0;

            for(int m = 0; m < M; m++){
                for(int n = 0; n < N; n++){
                    if(map[m][n] == 1){
                        bfs(m, n);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }//test case 종료

    }//main 종료

    public static void bfs(int m, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{m, n});
        map[m][n] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int curX = current[0];
            int curY = current[1];
            //상
            if(curY-1>=0 && map[curX][curY-1] == 1){
                q.add(new int[]{curX, curY-1});
                map[curX][curY-1] = 0;
            }
            //하
            if(curY+1<N && map[curX][curY+1] == 1){
                q.add(new int[]{curX, curY+1});
                map[curX][curY+1] = 0;
            }
            //좌
            if(curX-1>=0 && map[curX-1][curY] == 1){
                q.add(new int[]{curX-1, curY});
                map[curX-1][curY] = 0;
            }
            //우
            if(curX+1<M && map[curX+1][curY] == 1){
                q.add(new int[]{curX+1, curY});
                map[curX+1][curY] = 0;
            }
        }

    }
}