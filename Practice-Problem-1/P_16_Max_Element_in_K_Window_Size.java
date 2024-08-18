import java.util.*;
public class P_16_Max_Element_in_K_Window_Size {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int result[] = maxElementAtMostKSizeWindow(arr,n,k);
        print(result);
    }
    public static void print(int arr[]){
        for(int a:arr)System.out.print(a+" ");
        System.out.println("");
    }
    public static int[] maxElementAtMostKSizeWindow(int arr[], int n, int k){
        int deque[] = new int[n];
        int l = 0;
        int r = 0;
        int result[] = new int[n-k+1];
        for(int i=0;i<n;i++){
            while(r>l && arr[deque[r-1]]<=arr[i])   r--;
            deque[r++] = i;
            if(i>=k-1){
                while(r>l && deque[l]<i-k+1) l++;
                result[i-k+1] = arr[deque[l]];
            }
        }
        return result;
    }
}