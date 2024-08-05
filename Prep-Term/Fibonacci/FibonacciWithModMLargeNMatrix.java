import java.util.Scanner;

public class FibonacciWithModMLargeNMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter MOD for Fibonacci(N): ");
        int MOD = sc.nextInt();
        System.out.print("Enter N to find Fibonacci(N) (as a large number): ");
        String nStr = sc.next();
        sc.close();
        
        int[][] x = {{1, 1}, {1, 0}};
        int[][] resultMatrix = matrixExponentiation(x, nStr, MOD);
        
        int fib = resultMatrix[1][0];
        System.out.println(fib);
    }

    public static int[][] matrixExponentiation(int[][] base, String exponentStr, int MOD) {
        int[][] result = {{1, 0}, {0, 1}};
        int[][] baseMatrix = base;
        
        char[] digits = exponentStr.toCharArray();
        
        for (int j = digits.length-1;j>=0;j--) {
            int current = digits[j] - '0';
            for (int i = 0; i < current; i++) {
                result = matrixMultiplication(result, baseMatrix, MOD);
            }
            int replaceBase[][] = {{1,0},{0,1}};
            for(int i=0;i<10;i++){
                replaceBase = matrixMultiplication(replaceBase, baseMatrix, MOD);
            }

            baseMatrix = replaceBase;
        }
        
        return result;
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b, int MOD) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + (a[i][k] * b[k][j]) % MOD) % MOD;
                }
            }
        }
        return result;
    }
}
