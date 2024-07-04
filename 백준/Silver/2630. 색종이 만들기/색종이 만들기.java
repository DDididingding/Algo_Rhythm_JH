import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(str[j]);
            }
        }

        Cut(0, N, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void Cut(int xStart, int xEnd, int yStart, int yEnd){
        int now = paper[yStart][xStart];
        boolean perfect = true;

        loop:
        for(int i = yStart; i < yEnd; i++){
            for(int j = xStart; j < xEnd; j++){
                if(paper[i][j] != now){
                    int xMid = (xStart+xEnd)/2;
                    int yMid = (yStart+yEnd)/2;
                    //4개로 분할
                    Cut(xStart, xMid, yStart, yMid); //왼쪽 위
                    Cut(xMid, xEnd, yStart, yMid); // 오른쪽 위
                    Cut(xStart, xMid, yMid, yEnd); // 왼쪽 아래
                    Cut(xMid, xEnd, yMid, yEnd); // 오른쪽 아래

                    perfect = false;
                    break loop;
                }
            }
        }

        if (perfect) {
            if (now == 0) white++;
            else if (now == 1) blue++;
        }
    }
}