import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1) bfs(i, j);
            }
        }

        System.out.println(answers.size());
        Collections.sort(answers);
        for(int answer : answers){
            System.out.println(answer);
        }
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        int cnt = 0;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cury = cur[0];
            int curx = cur[1];

            if(map[cury][curx] == 0) continue;
            map[cury][curx] = 0; // Mark as visited
            cnt++;

            for(int i = 0; i < 4; i++){
                int newY = cury + dy[i];
                int newX = curx + dx[i];

                if(newY >= 0 && newY < N && newX >= 0 && newX < N && map[newY][newX] == 1){
                    q.offer(new int[]{newY, newX});
                }
            }
        }

        answers.add(cnt);
    }
}