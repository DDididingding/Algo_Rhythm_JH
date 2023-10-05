import java.util.*;
import java.io.*;

class Solution {
    static int result;
    static int[] numbers;
    static int len;
    
    public int solution(int[] nums) {
        len = nums.length;
        numbers = new int[len];
        for(int i = 0 ; i<len; i++){
            numbers[i] = nums[i];
        }
        
        comb(0,0,0);
        
        
        int answer = result;
        return answer;
    }
    
    static void comb(int idx, int sum, int cnt){
        if(cnt == 3){
            result += isPrime(sum);
            return;
        }
        if(idx==len) return;
        
        comb(idx+1, sum+numbers[idx], cnt+1);
        comb(idx+1, sum, cnt);
    }
    
    static int isPrime(int P){
        for (int i = 2; i<=(int)Math.sqrt(P); i++) {
      if (P % i == 0) {
          return 0;
      }
	}
	return 1;
    }
}