import java.util.*;
public class P_23_MaxProfit_Atleast_KDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int result = maxProfitAtleastKDays(arr,k);
        System.out.println(result);
    }
    public static int maxProfitAtleastKDays(int arr[], int k){
        int result = 0;
        int min = arr[0];
        for(int i=k;i<arr.length;i++){
            if(min > arr[i-k]) min = arr[i-k];
            if(result < arr[i]-min) result = arr[i]-min;
        }
        return result;
    }
}