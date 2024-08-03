import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int nodes;
    static int roads;
    static int wormHoles;
    static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            nodes = Integer.parseInt(str[0]);
            roads = Integer.parseInt(str[1]);
            wormHoles = Integer.parseInt(str[2]);

            edges = new ArrayList<>();

            for (int r = 0; r < roads; r++) {
                str = br.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                int time = Integer.parseInt(str[2]);

                edges.add(new Edge(start, end, time));
                edges.add(new Edge(end, start, time)); 
            }

            for (int w = 0; w < wormHoles; w++) {
                str = br.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                int time = Integer.parseInt(str[2]);

                edges.add(new Edge(start, end, -time));
            }

            if (bellmanFord()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean bellmanFord() {
        int[] minDistance = new int[nodes + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0] = 0;

        for (int i = 1; i <= nodes; i++) {
            edges.add(new Edge(0, i, 0));
        }

        for (int i = 1; i <= nodes; i++) {
            for (Edge edge : edges) {
                if (minDistance[edge.start] != Integer.MAX_VALUE && minDistance[edge.start] + edge.weight < minDistance[edge.end]) {
                    minDistance[edge.end] = minDistance[edge.start] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (minDistance[edge.start] != Integer.MAX_VALUE && minDistance[edge.start] + edge.weight < minDistance[edge.end]) {
                return true;
            }
        }

        return false;
    }

    static class Edge {
        int start, end, weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}