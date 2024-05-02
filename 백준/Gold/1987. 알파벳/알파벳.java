import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int max;
    static int R;
    static int C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        R = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);
        max = 0;

        String[][] map = new String[R][C];
        for(int r  = 0; r < R; r++){
            map[r] = br.readLine().split("");
        }

        HashSet<String> visited = new HashSet<String>();
        
        dfs(0, 0, visited, map);

        System.out.println(max);

    }

    public static void dfs(int y, int x, HashSet<String> visited, String[][] map) {
        if(y < 0 || y >= R || x < 0 || x >= C || visited.contains(map[y][x])) {
            max = Math.max(max, visited.size());
            return;
        }
    
        visited.add(map[y][x]);
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            dfs(ny, nx, visited, map);
        }
        visited.remove(map[y][x]); // 백트래킹
    }
    
}