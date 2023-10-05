import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<food.length; i++){
            if(food[i]%2 == 1){
                food[i]--;
            }
            food[i] = food[i]/2;
            while(food[i]>0){
                sb.append(i);
                food[i]--;
            }
        }
        
        String answer = "";
        answer += sb;
        answer += "0";
        for(int i = sb.length()-1; i>=0; i--){
            answer += sb.charAt(i);
        }
        
        return answer;
    }
}