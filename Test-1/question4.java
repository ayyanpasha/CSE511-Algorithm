import java.util.*;
public class question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(findLength(s));
    }
    public static int findLength(String s){
        char[] characters = s.toCharArray();
        int n = characters.length;
        int count = 0;
        int map[] = new int[26];
        int i=0;
        int minLength = Integer.MAX_VALUE;
        
        for(int j=0;j<n;j++){
            if(map[characters[j]-'A'] == 0) count++;
            map[characters[j]-'A']++;
            while(count == 26 && i <=j){
                if(minLength > j-i+1) minLength = j-i+1;
                if(map[characters[i]-'A'] == 1) count--;
                map[characters[i]-'A']--;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}