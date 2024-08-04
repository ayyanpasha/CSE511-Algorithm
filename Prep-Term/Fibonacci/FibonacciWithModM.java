import java.util.*;

class FibonacciWithModM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter MOD value: ");
        int MOD = sc.nextInt();
        System.out.print("Enter N to find Fibonacci(N): ");
        int n = sc.nextInt();
        int fib[] = new int[6*MOD+3];
        fib[1] = 1;
        int p = findP(fib,MOD);
        System.out.println(p);
        System.out.print(fib[n%p]);
    }
    public static int findP(int fib[],int MOD){
        int i=2;
        for(;i<fib.length;i++){
            fib[i] = (fib[i-1]+fib[i-2])%MOD;
            if(fib[i-1] == fib[0] && fib[i] == fib[1]) break;
        }
        return i-1;
    }
}