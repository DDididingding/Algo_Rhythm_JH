import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int height;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        height = Integer.parseInt(str[0]);
        width = Integer.parseInt(str[1]);

        map = new int[height][width];

        for(int h = 0; h < height; h++){
            String[] M = br.readLine().split("");
            for(int w = 0; w < width; w++){
                map[h][w] = Integer.parseInt(M[w]);
            }
        }

        int answer = bfs(0,0);

        System.out.println(answer);

    }

    public static Integer bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        map[0][0] = 0;
        int len = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curL = cur[2];
            if(curY == height-1 && curX == width -1){
                len = curL;
                break;
            }


            int[] dy = {-1, 1, 0, 0}; //상하좌우
            int[] dx = {0, 0, -1, 1}; //상하좌우
            for (int i = 0; i < 4; i++) {
                if (curY + dy[i] < height && curY + dy[i] >= 0 && curX + dx[i] < width && curX + dx[i] >= 0) {
                    if (map[curY + dy[i]][curX + dx[i]] != 0) {
                        queue.offer(new int[]{curY + dy[i], curX + dx[i], curL + 1});
                        map[curY + dy[i]][curX + dx[i]] = 0;
                    }
                }
            }

        }
        return len;
    }
}