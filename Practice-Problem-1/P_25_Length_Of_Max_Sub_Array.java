import java.util.*;
public class P_25_Length_Of_Max_Sub_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int i = 0;
        int max = Integer.MIN_VALUE;
        int maxLength=0;
        int sum = 0;
        
        for(int j=0;j<n;j++){
            sum += arr[j];
            if(sum > max){
                max = sum;
                maxLength = (j-i+1);
            }
            if(sum<0){
                sum = 0;
                i = j+1;
            }
        }
        System.out.println(maxLength);
    }
}