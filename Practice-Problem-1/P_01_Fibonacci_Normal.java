import java.util.*;
public class P_01_Fibonacci_Normal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int fib[] = new int[m*6+3];
        int p = calculateP(m,fib);
        System.out.println(fib[n%p]);
    }
    public static int calculateP(int m, int fib[]){
        fib[0] = 0;
        fib[1] = 1;
        int i=2;
        for(;i<=6*m+2;i++){
            fib[i] = (fib[i-1]+fib[i-2])%m;
            if(fib[i] == 1 && fib[i-1] == 0) break;
        }
        return i-1;
    }
}