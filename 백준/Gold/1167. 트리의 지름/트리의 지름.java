import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    static int V;
    static ArrayList<ArrayList<int[]>> Tree;
    static int longest;
    static boolean[] visited;
    static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        V = Integer.parseInt(s);

        Tree = new ArrayList<>(V + 1);
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            Tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            String[] str = br.readLine().split(" ");
            int len = str.length;
            int start = Integer.parseInt(str[0]);
            for (int l = 1; l < len - 1; l += 2) {
                int end = Integer.parseInt(str[l]);
                int distance = Integer.parseInt(str[l + 1]);
                Tree.get(start).add(new int[]{end, distance});
            }
        }

        visited[1] = true;
        iterativeDFS(1);

        visited = new boolean[V + 1];
        longest = 0;

        visited[farthestNode] = true;
        iterativeDFS(farthestNode);

        System.out.println(longest);
    }

    public static void iterativeDFS(int start) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, 0});
        visited[start] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int node = current[0];
            int lenOfPath = current[1];

            if (lenOfPath > longest) {
                longest = lenOfPath;
                farthestNode = node;
            }

            for (int[] neighbor : Tree.get(node)) {
                int end = neighbor[0];
                int distance = neighbor[1];
                if (!visited[end]) {
                    visited[end] = true;
                    stack.push(new int[]{end, lenOfPath + distance});
                }
            }
        }
    }
}