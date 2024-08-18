import java.util.*;
public class P_22_MaxProfit_After_Exactly_k_days {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int result = maxProfitKDays(arr,k);
        System.out.println(result);
    }
    public static int maxProfitKDays(int arr[], int k){
        int result = 0;
        for(int i=k;i<arr.length;i++){
            if(arr[i]-arr[i-k] > result) result = arr[i]-arr[i-k];
        }
        return result;
    }
}