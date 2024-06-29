import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int goal = Integer.parseInt(str[1]);

            System.out.println(Search(start, goal));
        }

    }

    public static String Search(int start, int goal){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, ""));
        boolean[] visited = new boolean[10000];

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int curNum = cur.number;
            String curLog = cur.commands;

            if(curNum == goal){
                return curLog;
            }

            // Calculate next states
            int nextD = (2 * curNum) % 10000;
            int nextS = (curNum == 0) ? 9999 : curNum - 1;
            int nextL = ((curNum % 1000) * 10) + (curNum / 1000);
            int nextR = ((curNum % 10) * 1000) + (curNum / 10);

            // Add to queue if not visited
            if (!visited[nextD]) {
                q.offer(new Pair(nextD, curLog + "D"));
                visited[nextD] = true;
            }
            if (!visited[nextS]) {
                q.offer(new Pair(nextS, curLog + "S"));
                visited[nextS] = true;
            }
            if (!visited[nextL]) {
                q.offer(new Pair(nextL, curLog + "L"));
                visited[nextL] = true;
            }
            if (!visited[nextR]) {
                q.offer(new Pair(nextR, curLog + "R"));
                visited[nextR] = true;
            }
        }

        return ""; // Should not reach here with valid inputs
    }

    static class Pair {
        int number;
        String commands;

        public Pair(int number, String commands) {
            this.number = number;
            this.commands = commands;
        }
    }
}