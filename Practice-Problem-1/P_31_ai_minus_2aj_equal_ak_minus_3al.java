//a[i]-2a[j]=a[k]-3a[l]
//a[i]+3a[l] = a[k]+2a[j];

import java.util.*;
public class P_31_ai_minus_2aj_equal_ak_minus_3al {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(pairsExist(arr));
    }
    public static boolean pairsExist(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int l=0;l<n;l++){
                if(i == l) continue;
                int k = 0;
                int j = n-1;
                int sum  = arr[i]+3*arr[l];
                while(k<j){
                    if(k == i || k == l){
                        k++;
                        continue;
                    }
                    if(j == i || j == l){
                        j--;
                        continue;
                    }
                    int currentSum = arr[k]+2*arr[j];
                    if(sum == currentSum) return true;
                    else if(sum > currentSum){
                        k++;
                    }else{
                        j--;
                    }
                }
            }
        }
        return false;
    }
}