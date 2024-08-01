import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<int[]>[] adjList;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int m = 0; m < M; m++){
            String[] str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            adjList[s].add(new int[]{e, c});
        }

        String[] str = br.readLine().split(" ");
        start = Integer.parseInt(str[0]);
        end = Integer.parseInt(str[1]);

        long result = dijkstra(start);

        System.out.println(result);
    }

    public static long dijkstra(int start){
        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curNode = (int) cur[0];
            long curDist = cur[1];

            if (curDist > dist[curNode]) continue;

            for (int[] neighbor : adjList[curNode]) {
                int nextNode = neighbor[0];
                long weight = neighbor[1];
                long newDist = curDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new long[]{nextNode, newDist});
                }
            }
        }

        return dist[end];
    }
}