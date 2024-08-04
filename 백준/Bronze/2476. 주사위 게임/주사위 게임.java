import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int maxPrize = 0;

        for (int i = 0; i < N; i++) {
            int[] dice = new int[3];
            for (int j = 0; j < 3; j++) {
                dice[j] = scanner.nextInt();
            }
            int prize = calculatePrize(dice[0], dice[1], dice[2]);
            if (prize > maxPrize) {
                maxPrize = prize;
            }
        }

        System.out.println(maxPrize);
        scanner.close();
    }

    public static int calculatePrize(int a, int b, int c) {
        if (a == b && b == c) {
            return 10000 + a * 1000;
        } else if (a == b || a == c) {
            return 1000 + a * 100;
        } else if (b == c) {
            return 1000 + b * 100;
        } else {
            return Math.max(a, Math.max(b, c)) * 100;
        }
    }
}