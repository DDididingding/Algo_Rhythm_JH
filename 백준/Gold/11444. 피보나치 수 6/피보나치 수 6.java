import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static final BigInteger MOD = new BigInteger("1000000007");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());

        BigInteger result = fibo(n);
        System.out.println(result.mod(BigInteger.valueOf(1000000007)));
    }
    
    public static BigInteger[][] multiply(BigInteger[][] a, BigInteger[][] b) {
        BigInteger[][] result = new BigInteger[2][2];
        result[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])).mod(MOD);
        result[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1])).mod(MOD);
        result[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])).mod(MOD);
        result[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1])).mod(MOD);
        return result;
    }

    public static BigInteger[][] matrixPower(BigInteger[][] matrix, BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return matrix;
        }
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            BigInteger[][] halfPower = matrixPower(matrix, n.divide(BigInteger.TWO));
            return multiply(halfPower, halfPower);
        } else {
            return multiply(matrix, matrixPower(matrix, n.subtract(BigInteger.ONE)));
        }
    }

    public static BigInteger fibo(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        BigInteger[][] baseMatrix = { { BigInteger.ONE, BigInteger.ONE }, { BigInteger.ONE, BigInteger.ZERO } };
        BigInteger[][] resultMatrix = matrixPower(baseMatrix, n.subtract(BigInteger.ONE));

        return resultMatrix[0][0];
    }

}