import java.util.*;
//TC O(MOD + logN)
//SC O(M + logN)
class FibonacciWithModMLargeN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter MOD value: ");
        int MOD = sc.nextInt();
        System.out.print("Enter N to find Fibonacci(N) (Can be greater than 2^32): ");
        String n = sc.next();
        int fib[] = new int[6*MOD+3];
        fib[1] = 1;
        int p = findP(fib,MOD);
        int nModp = findMOD(n,p);
        System.out.print(fib[nModp]);
    }
    public static int findMOD(String n, int p){
        char[] numbers = n.toCharArray();
        int r = 0;
        for(char number:numbers){
            int current = number-'0';
            r = (10*r+current)%p;
        }
        return r;
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