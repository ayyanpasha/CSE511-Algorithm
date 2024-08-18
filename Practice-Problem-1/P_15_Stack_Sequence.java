import java.util.*;
public class P_15_Stack_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] str = string.toCharArray();
        int pointer = 0;
        int n = string.length();
        int top = -1;
        int stack[] = new int[n];
        for(int i=1;i<=n;i++){
            stack[++top] = i;
            while(top != -1 && pointer < n && stack[top] == str[pointer]-'0'){
                top--;
                pointer++;
            }
        }
        System.out.println(top == -1);
    }
}