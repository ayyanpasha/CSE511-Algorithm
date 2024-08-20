import java.util.*;

public class question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(findElement(arr,0,n-1,k));
    }
    public static int findElement(int arr[], int low, int high, int k){
        int karr[] = new int[2*k];
        for(int i=0;i<k;i++) karr[i+k] = arr[i];
        for(int i = k;i<=high;i += k){
            int j = 0;
            while(j<k && j+i<=high) karr[j] = arr[(j++)+i];
            while(j<k) karr[j++] = 0;
            quicksort(karr,0,2*k-1,k);
        }
        return karr[k];
    }
    public static int quicksort(int arr[], int low, int high, int k){
        int pivot = (int)Math.random()*(high-low+1) + low;
        swap(arr,high,pivot);
        int partition = partition(arr,low,high);
        if(high-partition+1 == k) return arr[partition];
        else if(high-partition+1 > k) return quicksort(arr,low+1,high,k);
        else return quicksort(arr,low,high-1,k-(high-partition+1));
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}