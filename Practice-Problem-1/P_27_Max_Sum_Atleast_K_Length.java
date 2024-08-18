import java.util.*;
public class P_27_Max_Sum_Atleast_K_Length {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int prefix[] = new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+arr[i];
        }
        int minIndex=0;
        int max = Integer.MIN_VALUE;
        int maxLength = 0;
        for(int i=k;i<=n;i++){
            if(prefix[minIndex] > prefix[i-k]) minIndex = i-k;
            if(prefix[i]-prefix[minIndex] > max){
                max = prefix[i]-prefix[minIndex];
                maxLength = i-minIndex;
            }
        }
        System.out.println(maxLength);
        System.out.println(max);
    }
}