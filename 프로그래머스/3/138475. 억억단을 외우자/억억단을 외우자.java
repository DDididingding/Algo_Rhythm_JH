class Solution {
    public int[] solution(int e, int[] starts) {
        int n = e + 1; // 배열 크기를 e보다 하나 더 크게 설정하여 인덱싱을 쉽게 합니다.
        int[] divisorsCount = new int[n];
        
        // 각 수의 약수의 개수를 계산합니다.
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divisorsCount[j]++;
            }
        }
        
        // e 이상부터 1까지 반복하면서 가장 많은 약수를 가진 수를 기록합니다.
        int[] mostDivisors = new int[n];
        int maxDivisors = 0;
        int maxDivisorsNumber = 0;
        
        for (int i = e; i >= 1; i--) {
            if (divisorsCount[i] >= maxDivisors) {
                maxDivisors = divisorsCount[i];
                maxDivisorsNumber = i;
            }
            mostDivisors[i] = maxDivisorsNumber;
        }
        
        // 시작 점들을 탐색하여 답을 찾습니다.
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = mostDivisors[starts[i]];
        }
        
        return answer;
    }
}