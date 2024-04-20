import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        String sentence = s.toLowerCase();
        String[] temp = sentence.split("");
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < temp.length; i++){
            if(i == 0){
                temp[i] = temp[i].toUpperCase();
            }else if(!temp[i].equals(" ") && temp[i-1].equals(" ")){
                temp[i] = temp[i].toUpperCase();
            }
            
            sb.append(temp[i]);
        }
        
        
        String answer = sb.toString();
        return answer;
    }
}