import java.util.Scanner;

public class FibonacciWtihModMMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter MOD for Fibonacci(N): ");
        int MOD = sc.nextInt();
        System.out.print("Enter N to find Fibonacci(N) (as a large number): ");
        int n = sc.nextInt();
        sc.close();
        
        int[][] x = {{1, 1}, {1, 0}};
        for(int i=0;i<n;i++){
            System.out.println(matrixExponentiation(x, i, MOD)[1][0]);
        }
        int[][] resultMatrix = matrixExponentiation(x, n, MOD);
        int fib = resultMatrix[1][0];
        System.out.println(fib);
    }

    // Function to compute matrix exponentiation
    public static int[][] matrixExponentiation(int[][] base, int n, int MOD) {
        int[][] result = {{1, 0}, {0, 1}}; // Identity matrix
        int[][] baseMatrix = base;
        
        while (n != 0) {
            if (n%2 == 1) {
                result = matrixMultiplication(result, baseMatrix, MOD);
            }
            baseMatrix = matrixMultiplication(baseMatrix, baseMatrix, MOD);
            n = n/2;
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
