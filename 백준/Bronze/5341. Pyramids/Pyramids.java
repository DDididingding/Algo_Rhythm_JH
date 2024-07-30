import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;

            int answer = 0;
            for(int i = 1; i <= n; i++){
                answer += i;
            }

            System.out.println(answer);

        }
    }
}