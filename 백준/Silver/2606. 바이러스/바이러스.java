import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> connection = new ArrayList<>();
        boolean[] visited = new boolean[computers+1];

        for(int i = 0; i <= computers; i++){
            connection.add(new ArrayList<>());
        }

        for(int i = 0; i < lines; i++){
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);

            connection.get(start).add(end);
            connection.get(end).add(start);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true; // 시작점 방문 처리

        while(!q.isEmpty()){
            int now = q.poll();
            int linkCnt = connection.get(now).size();
            for(int i = 0; i < linkCnt; i++){
                int linkedNode = connection.get(now).get(i);
                if(!visited[linkedNode]) {
                    visited[linkedNode] = true; // 방문 처리
                    q.offer(linkedNode);
                }
            }
        }

        int answer = 0;
        for(int i = 2; i <= computers; i++){
            if(visited[i]){
                answer++;
            }
        }

        System.out.println(answer);
    }
}