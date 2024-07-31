import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        int limit = (int) Math.sqrt(N);

        for(int i = 1; i <= limit; i++){
            if(N%i == 0){
                if(N/i == i){
                    list.add(i);
                }else {
                    list.add(i);
                    list.add(N / i);
                }
            }
        }

        Collections.sort(list);
        if(list.size()<K){
            System.out.println(0);
        }else{
            System.out.println(list.get(K-1));
        }

    }
}