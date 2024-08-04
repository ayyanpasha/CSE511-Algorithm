//Fib(n) = Fib(n-1)+Fib(n-2)
import java.util.*;
//TC O(logN)
//SC O(1)
class FibonacciWithModMLargeN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N to find Fibonacci(N): ");
        int n = sc.nextInt();
        int x[][] = {{1,1},{1,0}};
        //      [F(n)  ]  = [1 1]^n-1 * [F(1)]
        //      [F(n-1)]    [1 0]       [F[0]]
        int fib = power(x,n);
        System.out.print(fib);
    }
    public static int power(int x[][], int n){
        int y[][] = {{1,0},{0,1}};
        while(n != 0){
            if(n%2 == 1) y = matrixMultiplication(y,x);
            x = matrixMultiplication(x,x);
            n = n/2;
        }
        return y[1][0];
    }
    public static int[][] matrixMultiplication(int x[][], int y[][]){
        int result[][] = new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                result[i][j] = 0;
                for(int k=0;k<2;k++){
                    result[i][j] += x[i][k]*y[k][j];
                }
            }
        }
        return result;
    }
}