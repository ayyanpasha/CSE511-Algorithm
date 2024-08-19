import java.util.*;
public class question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(findBestPairRange(arr,x));
    }
    public static int findBestPairRange(int arr[], int x){
        int count = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            while(r<arr.length && arr[r]-arr[i] < x) r++;
            while(l<i && arr[i]-arr[l] >= x) l++;
            if(r-l > max) max = r-l;
        }
        return max;
        
    }
}