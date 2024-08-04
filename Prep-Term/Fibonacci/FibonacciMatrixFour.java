//Fib(n) = Fib(n-1)+Fib(n-4)
import java.util.*;
//TC O(logN)
//SC O(1)
class FibonacciMatrixFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N to find Fibonacci(N): ");
        int n = sc.nextInt();
        int x[][] = {
            {1,0,0,1},
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
        };
        // F[0] = 0, F[1] = 1, F[2] = 2,F[3] = 6
        //      [F(n)  ]  = [1 0 0 1]^n-3 * [F(3) = 6]
        //      [F(n-1)]    [1 0 0 0]       [F[2] = 2]
        //      [F(n-2)]    [0 1 0 0]       [F[1] = 1]
        //      [F(n-3)]    [0 0 1 0]       [F[0] = 0]
        int fib = power(x,n);
        System.out.println("Fib(" + n + ") = " + fib);
    }
    public static int power(int x[][], int n){
        int y[][] = {
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1}
        };
        while(n != 0){
            if(n%2 == 1) y = matrixMultiplication(y,x);
            x = matrixMultiplication(x,x);
            n = n/2;
        }
        int lastMatrix[][] = {{6},{2},{1},{0},{1}};
        int result[][] = matrixMultiplication(y,lastMatrix);
        return result[result.length-1][0];
    }
    public static int[][] matrixMultiplication(int matrixA[][], int matrixB[][]){
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
}