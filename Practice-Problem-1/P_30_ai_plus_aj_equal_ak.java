import java.util.*;
public class HelloWorld {
    public static class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        HashMap<Integer,Set<Pair>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                if(!map.containsKey(sum)) map.put(sum, new HashSet<Pair>());
                map.get(sum).add(new Pair(i,j));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int k = 0;k<n;k++){
            if(!map.containsKey(arr[k])) continue;
            for(Pair current:map.get(arr[k])){
                if(current.i == k || current.j == k) continue;
                result.add(Arrays.asList(current.i, current.j, k));
            }
        }
        System.out.println(result);
    }
}