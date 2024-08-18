import java.util.*;
public class P_29_Count_Element_Pair_Aj_minus_Ai_greaterThan_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int result = 0;
        int j=0;
        for(int i=0;i<n && j != n;i++){
            while(j < n && arr[j]-arr[i] <= k) j++;
            result += (n-j);
        }
        System.out.println(result);
    }
}