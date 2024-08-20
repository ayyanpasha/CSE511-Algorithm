import java.util.*;
public class question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double k = sc.nextDouble();
        
        long count = 0;
        
        double top = Math.floor(r);
        if(top == r) top--;
        
        double line = Math.ceil(k);
        if(line == k) line++;
        
        double y = top;
        double x = 0;
        for(;y>=0 && y >=line;y--){
            while(y*y + x*x < r*r) x++;
            count += 2*x-1;
        }
        for(;y>=line && y>=-top;y--){
           while(y*y + x*x >= r*r) x--;
           count += 2*x+1;
        }
        
        System.out.println(count);
        
    }
}
