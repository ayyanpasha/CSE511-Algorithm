//Question did not make sense, hence found max Sum with length K

import java.util.*;
public class P_26_Max_Sum_Length_K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int sum = 0;
        for(int i=0;i<k;i++) sum += arr[i];
        int max = sum;
        for(int i=k;i<n;i++){
            sum += arr[i]-arr[i-k];
            if(sum>max) max = sum;
        }
        System.out.println(max);
    }
}