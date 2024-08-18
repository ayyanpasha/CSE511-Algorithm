import java.util.*;
public class P_11_Left0_equalTo_Right1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] str = string.toCharArray();
        int n = string.length();
        int k = -1;
        for(char current:str){
            if(current == '1') k++;
        }
        System.out.println(k);
    }
}