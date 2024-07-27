import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 3; t++){
            String[] str = br.readLine().split(" ");
            int status = 0;

            for(int i = 0; i < 4; i++){
                if(str[i].equals("0")){
                    status++;
                }
            }

            switch (status){
                case 1 : System.out.println("A");
                    break;
                case 2 : System.out.println("B");
                    break;
                case 3 : System.out.println("C");
                    break;
                case 4 : System.out.println("D");
                    break;
                case 0 : System.out.println("E");
                    break;
            }

        }

    }
}