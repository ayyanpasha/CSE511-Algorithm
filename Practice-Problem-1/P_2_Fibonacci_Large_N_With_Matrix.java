import java.util.*;
public class P_2_Fibonacci_Large_N_With_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int m = sc.nextInt();
        int result[][] = calculateA_power_N(n,m);
        int multiplyFactor[][] = {{1},{0}};
        result = matrixMultiplication(result,multiplyFactor,m);
        System.out.println(result[result.length-1][0]);
    }
    
    public static int[][] calculateA_power_N(String n, int m){
        int y[][] = {{1,0},{0,1}};
        int base[][] = {{1,1},{1,0}};
        
        char number[] = n.toCharArray();
        
        for(int i=number.length-1;i>=0;i--){
            int z[][] = {{1,0},{0,1}};
            for(int j=1;j<=number[i]-'0';j++){
                z = matrixMultiplication(z,base,m);
            }
            y = matrixMultiplication(y,z,m);
            int replace[][] = {{1,0},{0,1}};
            for(int a=0;a<10;a++) replace = matrixMultiplication(replace,base,m);
            base = replace;
        }
        return y;
    }
    
    public static int[][] matrixMultiplication(int a[][], int b[][], int m){
        int rowA = a.length;
        int colA = a[0].length;
        int rowB = b.length;
        int colB = b[0].length;
        
        int result[][] = new int[rowA][colB];
        for(int i=0;i<rowA;i++){
            for(int j=0;j<colB;j++){
                int aij = 0;
                for(int k=0;k<colA;k++){
                    int current = (a[i][k]*b[k][j])%m;
                    aij = (aij+current)%m;
                }
                result[i][j] = aij;
            }
        }
        return result;
    }
}