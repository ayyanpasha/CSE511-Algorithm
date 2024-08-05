import java.util.*;
class FindRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in Array for RQS: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter index element to find Rank: ");
        int index = sc.nextInt();
        int rank = findRank(arr,index);
        System.out.println("Rank of "+arr[index]+" at index "+index+" is "+rank);
    }
    public static int findRank(int arr[], int eleIndex){
        int rank = 1;
        for(int a:arr){
            if(arr[eleIndex]>a) rank++;
        }
        return rank;
    }
}