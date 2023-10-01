import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        int cnt = 0;
        Arrays.sort(targets, (x,y) -> x[1]-y[1]);
        
        int end = 0;
        
        for(int i = 0; i<targets.length; i++){
            int s = targets[i][0];
            int e = targets[i][1];
            
            if(s<end){
                continue;
            }else{
                end = e;
                cnt++;
            }
        }
        
        
        int answer = cnt;
        return answer;
    }
}