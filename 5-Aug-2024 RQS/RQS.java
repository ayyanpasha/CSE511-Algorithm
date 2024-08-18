import java.util.*;

class RQS {
    public static void main(String[] args) {
        System.out.print("Enter number of elements in Array for RQS: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        RQS(arr,0,n-1);
        print(arr);
    }
    public static void RQS(int arr[], int l, int r){
        if(l>=r) return;
        int p = l + (int)Math.random()*(r-l+1);
        swap(arr,l,p);
        int k = partition(arr,l,r);
        RQS(arr,l,k-1);
        RQS(arr,k+1,r);
    }
    public static int partition(int arr[], int l, int r){
        int i = l;
        int j = r;
        int pivot = arr[l];
        while(i<=j){
            while(i<=j && arr[i]<=pivot)i++;
            while(i<=j && arr[j]>pivot)j--;
            if(i<j) {
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        i--;
        arr[l] = arr[i];
        arr[i] = pivot;
        return i;
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int arr[]){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println("");
    }
}