import java.util.*;
import java.io.*;

class Solution {
    static class node{
		int y;
		int x;
		node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        int Y = maps.length;
        int X = maps[0].length;
        int[] dely = {0,1,0,-1};
        int[] delx = {1,0,-1,0};
        int[][] depth = new int[Y][X];
        boolean arrived = false;
        
        boolean[][] visited = new boolean[Y][X];
        
        
        
        for(int i = 0; i<Y; i++){
            for(int j = 0; j<X; j++){
                if(maps[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }
        
        Queue<node> q = new LinkedList<>();
        q.offer(new node(0,0));
        visited[0][0] = true;
        depth[0][0] = 1;
        
        while(!q.isEmpty()){ //큐가 비어있지 않다면
            node curnode = q.poll(); //현재 앞에 있는 노드를 빼고
            for(int d = 0; d<4; d++){ //그리고 탐색 시작
                if(curnode.y+dely[d] >= 0 && curnode.y+dely[d] < Y && curnode.x+delx[d] >=0 && curnode.x+delx[d] <X){ //만약 내가 가려는 노드가 인덱스에 벗어나지 않고
                    if(!visited[curnode.y+dely[d]][curnode.x+delx[d]]){ //내가 가려는 노드가 방문되지 않은 노드라면
                        q.offer(new node(curnode.y+dely[d], curnode.x+delx[d])); //그 노드를 큐에 넣어준다
                        visited[curnode.y+dely[d]][curnode.x+delx[d]] = true; //노드를 넣으면서 방문처리
                        depth[curnode.y+dely[d]][curnode.x+delx[d]] = depth[curnode.y][curnode.x] +1;
                        if(curnode.y+dely[d] == Y-1 && curnode.x+delx[d] == X-1){ //근데 그 노드의 좌표가 도착점의 좌표라면
                            answer = depth[curnode.y+dely[d]][curnode.x+delx[d]]; //현재 깊이를 answer에 넣어주고
                            arrived = true; //도착했다고 표시해준다
                            break; // 그리고 멈춰
                        }
                    }
                    
                    
                }
            }
            
            if(arrived) break; //만약 도착했다고 표시했으면 while문 나가기 아니면 계속 돌기
            
        }
        
        
        return answer;
        
    }
}