import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("-"); // -를 기준으로 수를 분리
        int cnt = str.length;
        int[] nums = new int[cnt];
        int answer = 0;

        for(int i = 0; i < cnt; i++){
            String[] plus = str[i].split("\\+"); // +를 기준으로 수를 분리
            for(String fig : plus){
                int now = Integer.parseInt(fig);
                nums[i] += now; //각 블록의 수의 합을 기록
            }
        }

        for(int i = 0; i < cnt; i++){
            if(i == 0){
                answer += nums[i];
            }else{
                answer -= nums[i];
            }
        }

        System.out.println(answer);

    }
}