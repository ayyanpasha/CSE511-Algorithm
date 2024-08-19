import java.util.*;
public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(pairsExist(arr));
    }
    public static boolean pairsExist(int arr[]){
        int n = arr.length;
        for(int k=0;k<n;k++){
            int i = 0;
            int j = n-1;
            while(i<j){
                if(i == k){
                    i++; continue;
                }
                if(j == k){
                    j--; continue;
                }

                if(arr[i]+arr[j] == arr[k]) return true;
                if(arr[i]+arr[j] > arr[k]){
                    j--;
                }else{
                    i++;
                }
            }
        }
        return false;
    }
}