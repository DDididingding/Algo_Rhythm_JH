import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long howManyFriends = 0;

        // 이름 길이를 키로 하고, 해당 이름 길이를 가진 학생들의 등수 목록을 값으로 하는 맵
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            int length = name.length();
            // 해당 이름 길이를 가진 큐가 없다면 새로 생성
            map.putIfAbsent(length, new LinkedList<>());
            Queue<Integer> queue = map.get(length);
            // 큐에 현재 학생의 등수 추가 전, K 등수 차이 이내에 있는 학생 수 세기
            while (!queue.isEmpty() && i - queue.peek() > K) {
                queue.poll(); // K 등수 차이를 넘어선 학생은 큐에서 제거
            }
            // 큐에 남아 있는 학생 수 = 현재 학생과 이름 길이가 같으면서 등수 차이가 K 이하인 학생 수
            howManyFriends += queue.size();
            // 현재 학생의 등수를 큐에 추가
            queue.offer(i);
        }

        System.out.println(howManyFriends);
    }
}