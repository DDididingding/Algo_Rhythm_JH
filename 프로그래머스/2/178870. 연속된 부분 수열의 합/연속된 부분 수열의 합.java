import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = 0;
        int len = sequence.length;
        int ansLen = 9999999;
        int[] answer = new int[2];
        int total = 0;
        
        for(int i = 0; i < len; i++){
            //오른쪽 하나 추가
            total += sequence[i];
           
            //total보다 k가 크다면 total보다 k가 작아지거나 start와 i 가 같아질때까지 오른쪽으로 이동
            while(total>k && start < i){
                total -= sequence[start++];
            }
            
             //구간의 합이 k가 되면 현재 구간의 길이와 답의 길이를 비교한 후,
            //더 짧으면 답으로 저장
            if(total == k){
                if(i - start < ansLen){
                    answer[0] = start;
                    answer[1] = i;
                    ansLen = i - start;
                }
            }
            
        }
        

        return answer;
    }
}