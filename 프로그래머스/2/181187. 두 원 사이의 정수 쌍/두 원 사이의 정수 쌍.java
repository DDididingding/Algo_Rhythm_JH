import java.util.*;
import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            double maxY = Math.sqrt(Math.pow(r2,2) - Math.pow(x,2));
            double lowY = Math.sqrt(Math.pow(r1,2) - Math.pow(x,2));
            
            if (Double.isNaN(lowY)) {
                lowY = 0;
            }
            int upper = (int) Math.floor(maxY);
            int lower = (int) Math.ceil(lowY);
            answer += upper - lower + 1;
        }

        answer *= 4;

        return answer;
    }
}