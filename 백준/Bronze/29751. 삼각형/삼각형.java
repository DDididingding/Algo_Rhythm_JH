import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float W = sc.nextInt();
        float H = sc.nextInt();

        float area = W*H/2;

        System.out.println(area);
    }
}