import java.util.*;
public class P_35_Find_Element_of_Rank_K_Sorted_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        int arr[] = new int[n];
        int brr[] = new int[m];
        for(int i = 0;i<n;i++) arr[i] = sc.nextInt();
        for(int i = 0;i<m;i++) brr[i] = sc.nextInt();
        
        int la = 0;
        int lb = 0;
        int ra = n-1;
        int rb = m-1;
        System.out.println(findRank(arr,brr,la,lb,ra,rb,k));
    }
    public static int findRank(int arr[], int brr[], int la, int lb, int ra, int rb, int k){
        int midA = (ra+la)/2;
        int midB = (rb+lb)/2;
        if(k == 0){
            int result = Integer.MAX_VALUE;
            if(ra<arr.length-1) result = Math.min(result,arr[ra+1]);
            if(rb<brr.length-1) result = Math.min(result,brr[rb+1]);
            return result;
        }
        if(ra>=la && rb>=lb){
            if(k <= (ra-la+rb-lb+2)/2){
                if(arr[midA] < brr[midB]){
                    return findRank(arr,brr,midA+1,lb,ra,rb,k);
                }
                else {
                    return findRank(arr,brr,la,midB+1,ra,rb,k);
                }
            }else{
                if(arr[midA]<brr[midB]) {
                    return findRank(arr,brr,la,lb,ra,midB-1,k-(rb-midB+1));
                }
                else{
                    return findRank(arr,brr,la,lb,midA-1,rb,k-(ra-midA+1));
                }
            }
        }else if(ra >= la){
            return findRank(arr,brr,la,lb,ra-k,rb,0);
        }else{
            return findRank(arr,brr,la,lb,ra,rb-k,0);
        }
    }
}