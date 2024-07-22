import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int N;
    static int M;
    static int[] dn = {-1,1,0,0}; //상하좌우
    static int[] dm = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        int timeToMelt = 0;


        for(int n = 0; n<N; n++){
            str = br.readLine().split(" ");
            for(int m = 0; m<M; m++){
                map[n][m] = Integer.parseInt(str[m]);
            }
        }

        // 일반치즈 = 1, 녹을치즈 = 2, 외부 = 3, 내부 = 4
        //가장자리를 모두 bfs하여 외부로 정의
        findOutside(new int[]{0,0});

        //외부가 표시 되지 않은 부분은 내부로 정의
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                if(map[n][m] == 0) map[n][m] = 4;
            }
        }

        while(melt()){ //녹이는 과정이 끝났으면
            timeToMelt++;
            for(int n = 2; n < N-2; n++){
                for(int m = 2; m < M-2; m++){
                    if(map[n][m] == 4){//내부공간을 검사

                        for(int i = 0; i<4; i++){
                            if(map[n+dn[i]][m+dm[i]] == 3){ //외부와 맞닿은 점이 있다면
                                open(new int[]{n,m}); //공간 열기
                                break;
                            }
                        }

                    }
                }
            }
        }

        System.out.println(timeToMelt);

    }

    static void findOutside(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        map[start[0]][start[1]] = 3;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curN = cur[0];
            int curM = cur[1];

            for(int i = 0; i<4; i++){
                if(curN+dn[i] >= 0 && curN+dn[i] < N && curM+dm[i] >= 0 && curM+dm[i] <M && map[curN+dn[i]][curM+dm[i]] == 0){
                    q.offer(new int[]{curN+dn[i], curM+dm[i]});
                    map[curN+dn[i]][curM+dm[i]] = 3;
                }
            }
        }
    }

    static boolean melt(){
        int meltingCheese = 0;
        //녹을 치즈가 있는지 확인
        for(int n = 1; n < N-1; n++){
            for(int m = 1; m < M-1; m++){
                if(map[n][m] == 1){
                    int count = 0;
                    for(int i = 0; i < 4; i++){
                        if(map[n+dn[i]][m+dm[i]] == 3) count++;
                    }
                    if(count >= 2){
                        map[n][m] = 2;
                        meltingCheese++;
                    }
                }
            }
        }
        //녹을 치즈가 없으면
        if(meltingCheese == 0) return false;

        //녹을 치즈가 있으면 치즈 녹이기
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                if(map[n][m] == 2) map[n][m] = 3;
            }
        }
        //다 녹인 후 true 반환

        return true;

    }

    static void open(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        map[start[0]][start[1]] = 3;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curN = cur[0];
            int curM = cur[1];

            for(int i = 0; i<4; i++){
                if(curN+dn[i] >= 0 && curN+dn[i] < N && curM+dm[i] >= 0 && curM+dm[i] <M && map[curN+dn[i]][curM+dm[i]] == 4){
                    q.offer(new int[]{curN+dn[i], curM+dm[i]});
                    map[curN+dn[i]][curM+dm[i]] = 3;
                }
            }
        }
    }
}