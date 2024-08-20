import java.util.*;
public class question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String n = sc.next();
            int k = sc.nextInt();
            int count = 0;
            
            char number[] = n.toCharArray();
            for(char num:number){
                if(num-'0' == k) count++;
            }
            System.out.println(count);
            t--;
        }
    }
}