import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        ArrayList<ArrayList<Integer>> gr = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            if (!gr.get(a).contains(b)) {
                gr.get(a).add(b);
                gr.get(b).add(a);
            }
        }

        int minNode = 1;
        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    int dist = distance(i, j, gr);
                    if (dist == -1) {  // 추가: 경로가 존재하지 않으면 무한대 거리로 설정
                        sum = Integer.MAX_VALUE;
                        break;
                    }
                    sum += dist;
                }
            }
            if (sum < minSum) {
                minSum = sum;
                minNode = i;
            }
        }

        System.out.println(minNode);
    }

    public static int distance(int start, int end, ArrayList<ArrayList<Integer>> gr) {
        boolean[] visited = new boolean[gr.size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (node == end) {
                return dist;
            }

            for (int neighbor : gr.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                }
            }
        }

        return -1; // 경로가 존재하지 않는 경우
    }
}