import java.util.*;
public class P_18_NextGreaterElementToLeft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int result[] = nextgreaterElementToLeft(arr,n);
        print(result);
    }
    public static void print(int arr[]){
        for(int a:arr)System.out.print(a+" ");
        System.out.println("");
    }
    public static int[] nextgreaterElementToLeft(int arr[], int n){
        int stack[] = new int[n];
        int result[] = new int[n];
        Arrays.fill(result,-1);
        int top = -1;
        for(int i=0;i<n;i++){
            while(top != -1 && arr[stack[top]] <= arr[i]) top--;
            if(top != -1) result[i] = stack[top];
            stack[++top] = i;
        }
        return result;
    }
}