import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();

        int term1 = K*C*(C+1)/2;
        int term2 = P*C*(C+1)*(2*C+1)/6;

        System.out.println(term1+term2);
    }
}