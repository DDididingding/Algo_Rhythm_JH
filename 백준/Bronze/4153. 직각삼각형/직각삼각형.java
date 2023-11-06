import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}