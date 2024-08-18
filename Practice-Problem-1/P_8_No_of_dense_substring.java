import java.util.*;
public class P_8_No_of_dense_substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int n = string.length();
        int prefix[] = new int[n+1];
        int count = 0;
        char[] str = string.toCharArray();
        for(int i=1;i<=n;i++){
            count += str[i-1] == '0'?1:-1;
            prefix[i] = count;
        }
        int result = mergeSort(prefix,0,n);
        System.out.println(result);
    }
    
    public static int mergeSort(int prefix[], int low, int high){
        int count = 0;
        if(low<high){
            int mid = (low+high)/2;
            count += mergeSort(prefix,low,mid)+mergeSort(prefix,mid+1,high)+merge(prefix,low,mid,high);
        }
        return count;
    }
    public static int merge(int prefix[], int low, int mid, int high){
        int temp[] = new int[high-low+1];
        int count = 0;
        int i=0;
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high){
            if(prefix[left]<=prefix[right]){
                temp[i++] = prefix[left++];
            }else{
                count += (mid-left+1);
                temp[i++] = prefix[right++];
            }
        }
        while(left<=mid){
            temp[i++] = prefix[left++];
        }
        while(right<=mid){
            temp[i++] = prefix[right++];
        }
        for(int j=0;j<i;j++){
            prefix[low+j] = temp[j];
        }
        return count;
    }
}