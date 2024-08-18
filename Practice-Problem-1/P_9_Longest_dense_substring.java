import java.util.*;
public class P_9_Longest_dense_substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] str = string.toCharArray();
        int n = string.length();
        int map[] = new int[2*n+2];
        Arrays.fill(map,-1);
        int count = n;
        int result = 0;
        for(int i=0;i<n;i++){
            count += str[i] == '0'?-1:1;
            if(count>n){
                result = i+1;
            }
            else if(map[count] == -1){
                map[count] = i;
            }else if(i-map[count-1]+1>result){
                result = i-map[count-1];
            }
        }
        System.out.println(result);
    }
}