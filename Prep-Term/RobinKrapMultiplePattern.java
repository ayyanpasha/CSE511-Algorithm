import java.util.*;
class RobinKrapMultiplePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of Binary Text: ");
        int n = sc.nextInt();
        int text[] = new int[n];
        System.out.println("Input Binary Text");
        for(int i=0;i<n;i++){
            text[i] = sc.nextInt();
        }
        System.out.print("Enter Number of Patterns to match: ");
        int m = sc.nextInt();
        System.out.print("Enter the Length for each Pattern: ");
        int k = sc.nextInt();
        int patterns[][] = new int[m][k];
        for(int i=0;i<m;i++){
            System.out.println("Enter "+k+" numbers for Pattern "+(i+1));
            for(int j=0;j<k;j++){
                patterns[i][j] = sc.nextInt();
            }
        }

        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<m;i++){
            int value = patternValue(patterns[i]);
            freq.put(value,freq.getOrDefault(value,0)+1);
        }
        int result = countSubStringMatch(text,freq,k);
        System.out.println(result);
    }
    
    public static int patternValue(int pattern[]){
        int x = 0;
        for(int i=0;i<pattern.length;i++){
            x = x*2+pattern[i];
        }
        return x;
    }
    
    public static int countSubStringMatch(int[] text, HashMap<Integer,Integer> map, int k){
        int count = 0;
        
        int y = 0;
        int z = 1;
        
        for(int i=0;i<k;i++){
            y = y*2+text[i];
            z = z*2;
        }
        
        for(int i=k;i<=text.length;i++){
            if(map.containsKey(y)){
                count += map.get(y);
                map.remove(y);
            }
            
            if(i<text.length){
                y = 2*y+text[i]-z*text[i-k];
            }
        }
        return count;
    }
}