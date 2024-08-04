import java.util.*;

class RobinKrapBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of Binary Text");
        int n = sc.nextInt();
        System.out.println("Enter "+n+" Binary bit values for Text");
        int text[] = new int[n];
        for(int i=0;i<n;i++) text[i] = sc.nextInt();
        
        System.out.println("Enter Length of Binary Pattern");
        n = sc.nextInt();
        System.out.println("Enter "+n+" Binary bit values for Pattern");
        int pattern[] = new int[n];
        for(int i=0;i<n;i++) pattern[i] = sc.nextInt();

        System.out.println(substring(pattern,text));
    }
    public static boolean substring(int pattern[], int text[]){
        int x = 0;
        int y = 0;
        int z = 1;
        
        int i=0;
        for(;i<pattern.length;i++){
            x = 2*x+text[i];
            y = 2*y+pattern[i];
            z = 2*z;
        }
        do{
            if(x == y) return true;
            x = 2*x+text[i]-z*text[i-pattern.length];
            i++;
        }while(i<text.length);
        return false;
    }
    
}