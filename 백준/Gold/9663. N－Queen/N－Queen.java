import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static boolean[][] board;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        long startTime = System.currentTimeMillis();

        N = sc.nextInt();

        board = new boolean[N][N];

        put(board, 0, new boolean[N], 0);

        System.out.println(answer);

//        long endTime = System.currentTimeMillis();
//        long duration = endTime - startTime;
//
//        System.out.println("Execution time in milliseconds: " + duration);

    }

    public static void put(boolean[][] board, int x, boolean[] y, int Queen){
        if(x>=1 && !check(board, x-1)) return;

        if(Queen == N){
            answer++;
            return;
        }
        for(int j = 0; j< N; j++){
            if(!y[j]){ //x, y가 모두 놓이지 않았으면
                board[j][x] = true;
                y[j] = true;

                put(board,x+1,y,Queen+1);

                board[j][x] = false;
                y[j] = false;
            }
        }
    }

    public static boolean check(boolean[][] board, int x){
        int[] dy = {-1, 1};

        for(int j = 0; j< N; j++){
            if(board[j][x]){
                int xNow = x; //위 대각선 체크
                int yNow = j;
                while(xNow > 0 && yNow > 0){
                    xNow -= 1;
                    yNow += dy[0];
                    if(board[yNow][xNow]){
                        return false;
                    }
                }
                xNow = x;
                yNow = j;
                while(xNow > 0 && yNow<N-1){
                    xNow -= 1; //아래 대각선 체크
                    yNow += dy[1];
                    if(board[yNow][xNow]){
                        return false;
                    }
                }

            }
        }
        return true;
    }

}