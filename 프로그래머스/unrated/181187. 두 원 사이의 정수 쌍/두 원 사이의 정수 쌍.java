import java.util.*;
import java.io.*;

class Solution {
    long answer = 0;
    public long solution(int r1, int r2) {
        int cnt = 0; //개수 세기
        for(int i = 1; i<=r2; i++){ //0~r2까지의 좌표를 탐방
            double y2 = Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            double y1 = Math.sqrt(Math.pow(r1,2) - Math.pow(i,2));
            
            answer += (long)y2 - (long)Math.ceil(y1) +1;
            
        }
        
        answer = 4*answer;

        return answer;
    }
    
}