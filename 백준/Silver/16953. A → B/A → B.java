import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        //1<=A<B<=1000000000

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{A,1});

        while(!q.isEmpty()){
            long[] cur = q.poll();
            long curFig = cur[0];
            long curTry = cur[1];

            if(curFig*2 == B || curFig*10+1 == B){
                System.out.println(curTry+1);
                return;
            }

            if(curFig*2 < B) q.offer(new long[]{curFig*2, curTry+1});
            if(curFig*10+1 < B) q.offer(new long[]{curFig*10+1, curTry+1});

        }

        System.out.println(-1);

    }
}