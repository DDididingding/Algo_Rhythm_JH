import java.util.Scanner;

public class Main {
    static final int MOD = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long B = sc.nextLong();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] result = matrixPower(matrix, B, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static int[][] matrixPower(int[][] matrix, long exp, int size) {
        int[][] result = new int[size][size];

        // 결과 행렬을 단위 행렬로 초기화
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = matrixMultiply(result, matrix, size);
            }
            matrix = matrixMultiply(matrix, matrix, size);
            exp /= 2;
        }

        return result;
    }

    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2, int size) {
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (result[i][j] + matrix1[i][k] * matrix2[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}