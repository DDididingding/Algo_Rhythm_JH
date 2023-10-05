import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        int len = edge.length;
        int maxLen = 0;
        
        boolean[] visited = new boolean[n+1]; //방문 했는지 검사
        int[] distance = new int[n+1]; //1로부터의 거리를 저장하기 위한 배열
        
        ArrayList<ArrayList<Integer>> line = new ArrayList<>(); //
        
        for(int i = 0; i < n+1; i++){
            line.add(new ArrayList<>());
        }
        
        for(int i = 0; i< len; i++){
            line.get(edge[i][0]).add(edge[i][1]);
            line.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        visited[1] = true;
        while(!Q.isEmpty()){
            int curnode = Q.poll();//맨 앞에 있는 아이를 빼면서 얘를 중심으로 탐색
            for(int j = 0; j<line.get(curnode).size();j++){
                
                if(!visited[line.get(curnode).get(j)]){//방문한적이 없는 노드면
                    Q.offer(line.get(curnode).get(j)); //얘에 연결된 아이들을 하나씩 큐에 넣는데
                    visited[line.get(curnode).get(j)] = true; //방문처리를 해주고
                    distance[line.get(curnode).get(j)] = distance[curnode] +1; //현재 탐색중인 노드에 나보다 +1 해준다.
                    if(maxLen<distance[line.get(curnode).get(j)]) maxLen = distance[line.get(curnode).get(j)];                      //거리의 최댓값을 작업때마다 갱신
                }
            }
            
        }
        
        
        
        int answer = 0;
        
        for(int i = 1; i<=n; i++){
            if(distance[i] == maxLen) answer++;
        }
        
        return answer;
    }
}