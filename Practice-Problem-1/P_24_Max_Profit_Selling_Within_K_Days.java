import java.util.*;
public class P_24_Max_Profit_Selling_Within_K_Days {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int deque[] = new int[n];
        int r = 0;
        int l = 0;
        int result = 0;
        for(int i=0;i<n;i++){
            while(r>l && arr[deque[r-1]]>=arr[i]) r--;
            deque[r++] = i;
            while(r>l && deque[l] < i-k) l++;
            if(arr[i]-arr[deque[l]] > result)  result = arr[i]-arr[deque[l]];
        }
        System.out.println(result);
    }
}