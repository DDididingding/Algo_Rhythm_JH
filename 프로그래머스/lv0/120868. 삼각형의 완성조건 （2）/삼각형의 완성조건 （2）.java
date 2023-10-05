class Solution {
    public int solution(int[] sides) {
        
        int maxLen = sides[0]+sides[1]-1;
        int minLen = Math.max(sides[0], sides[1]) - Math.min(sides[0], sides[1]) +1;
        
        
        int answer = maxLen - minLen +1;
        return answer;
    }
}