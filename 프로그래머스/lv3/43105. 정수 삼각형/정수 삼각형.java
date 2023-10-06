import java.util.*;
import java.io.*;

class Solution {

    static int len;

    public int solution(int[][] triangle) {
        len = triangle.length;
        // Tri = new int[len][len];
        // for(int i = 0 ; i<triangle.length; i++){
        //     for(int j = 0; j<triangle[i].length; j++){
        //         Tri[i][j] = triangle[i][j];
        //     }
        // }
        
        for(int i = 1 ; i<len; i++){
            for(int j = 0; j<triangle[i].length; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == triangle[i].length -1){
                    triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
        }
        // for(int i  = 0; i<len; i++){
        //          System.out.println(Arrays.toString(triangle[i]));
        // }
   
         int answer = 0;
        Arrays.sort(triangle[len-1]);
        answer = triangle[len-1][len-1];

       
        return answer;
    }
    
    
    
}