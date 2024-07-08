import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int X;
    static int Y;
    static int Z;
    static int[][][] box;
    static int unripeTomato = 0;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dz = {0, 0, 0, 0 , -1, 1}; //front back left right up down
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int maxDate = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        X = Integer.parseInt(str[0]);
        Y = Integer.parseInt(str[1]);
        Z = Integer.parseInt(str[2]);

        box = new int[Z][Y][X];


        for(int z = 0; z < Z; z++){
            for(int y = 0; y < Y; y++){
                String[] toms = br.readLine().split(" ");
                for(int x = 0; x < X; x++){
                    int status = Integer.parseInt(toms[x]);
                    box[z][y][x] = status;
                    if(status == 0) unripeTomato++;
                    if(status == 1) q.offer(new int[]{z, y, x, 0});
                }
            }
        } // input status of tomato

        if(unripeTomato == 0){
            System.out.println(maxDate);
            return;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curZ = cur[0];
            int curY = cur[1];
            int curX = cur[2];
            int curDate = cur[3];

            ripe(curZ, curY, curX, curDate);

        }

        if(unripeTomato != 0){
            System.out.println(-1);
            return;
        }

        System.out.println(maxDate);


    }

    public static void ripe(int z, int y, int x, int curDate){
        for(int i = 0; i < 6; i++){
            int newZ = z+dz[i];
            int newY = y+dy[i];
            int newX = x+dx[i];
            if(newZ < Z && newZ >=0 && newY < Y && newY >= 0 && newX < X && newX >= 0 && box[newZ][newY][newX] == 0){
                q.offer(new int[]{newZ, newY, newX, curDate+1});
                box[newZ][newY][newX] = 1;
                unripeTomato--;
                if(maxDate < curDate+1) maxDate = curDate+1;
            }
        }

    }
}