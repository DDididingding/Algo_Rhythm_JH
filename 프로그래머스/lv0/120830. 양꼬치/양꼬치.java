class Solution {
    public int solution(int n, int k) {
        k = k - n/10;
        int answer = (12000*n) + (2000*k);
        return answer;
    }
}