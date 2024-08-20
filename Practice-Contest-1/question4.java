import java.util.*;
public class question4 {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        long result[][] = calculatePower(n);
        long multiplyFactor[][] = new long[100][1];
        for(int j=0;j<=99;j++) multiplyFactor[j][0] = 99-j;
        result = multiply(result,multiplyFactor);
        System.out.println(result[result.length-1][0]);
        
    }
    public static long[][] calculatePower(String n){
        long base[][] = new long[100][100];
        base[0][98] = 1;
        base[0][99] = 1;
        for(int i=1;i<100;i++){
            base[i][i-1] = 1;
        }
        
        long result[][] = new long[100][100];
        for(int i=0;i<100;i++) result[i][i] = 1;
        
        char current[] = n.toCharArray();
        
        int i = current.length-1;
        for(;i>=0;i--){
            long z[][] = new long[100][100];
            for(int j=0;j<100;j++) z[j][j] = 1;
            long value = current[i]-'0';
            while(value>0){
                z = multiply(z,base);
                value--;
            }
            result = multiply(result,z);
            long replace[][] = new long[100][100];
            for(int j=0;j<100;j++) replace[j][j] = 1;
            
            for(long j=0;j<10;j++){
                replace = multiply(replace,base);
            }
            base = replace;
        }
        return result;
    }
    public static long[][] multiply(long a[][], long b[][]){
        int ra = a.length;
        int ca = a[0].length;
        int rb = b.length;
        int cb = b[0].length;
        long result[][] = new long[ra][cb];
        for(int i=0;i<ra;i++){
            for(int j=0;j<cb;j++){
                long sum = 0;
                for(int k=0;k<ca;k++){
                    long current = (a[i][k]*b[k][j])%MOD;
                    sum = (sum+current)%MOD;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
