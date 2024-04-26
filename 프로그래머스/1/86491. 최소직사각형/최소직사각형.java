import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        
        for(int[] card : sizes){
            if(card[0] < card[1]){
                int temp = card[0];
                card[0] = card[1];
                card[1] = temp;
            }
            
            if(maxW<card[0]){
                maxW = card[0];
            }
            
            if(maxH<card[1]){
                maxH = card[1];
            }
        }
        
        answer = maxW*maxH;
        
        return answer;
    }
}