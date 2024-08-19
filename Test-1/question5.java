import java.util.*;

public class question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(calculateMaxSum(arr));
    }
    
    public static long calculateMaxSum(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i=n-1;i>= 0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int leftOptions = i-prevGreater[i];
            int rightOptions = nextGreater[i]-i;
            sum += (long)arr[i]*leftOptions*rightOptions;
        }
        return sum;
    }
}
