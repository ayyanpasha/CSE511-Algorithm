import java.util.*;
public class HelloWorld {
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
        int deque[] = new int[n+1];
        int r = 0;
        int l = 0;
        
        int max = Integer.MIN_VALUE;
        int maxLength = 0;
        
        for(int i=0;i<=n;i++){
            while(r>l && prefix[deque[r-1]] >= prefix[i]) r--;
            deque[r++] = i;
            while(r>l && deque[l] < i-k) l++;
            if(prefix[i]-prefix[deque[l]] > max){
                max = prefix[i]-prefix[deque[l]];
                maxLength = i-deque[l];
            }
        }
        //To handle if all array elements are negative
        boolean allNegative = true;
        int maxNegative = Integer.MIN_VALUE;
        for(int a:arr){
            if(a >=0 ) {
                allNegative = false;
            }
            maxNegative = Math.max(maxNegative,a);
            if(!allNegative) break;
        }
        if(allNegative) {maxLength = 1;max=maxNegative;}
        System.out.println(maxLength);
        System.out.println(max);
    }
}