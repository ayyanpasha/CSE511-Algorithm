//a[i]-2a[j]=a[k]-3a[l]

import java.util.*;
public class P_31_ai_minus_2aj_equal_ak_minus_3al {
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
            for(int j=0;j<n;j++){
                if(i == j) continue;
                int sum = arr[i]-2*arr[j];
                if(!map.containsKey(sum)) map.put(sum, new HashSet<Pair>());
                map.get(sum).add(new Pair(i,j));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int k=0;k<n;k++){
            for(int l=0;l<n;l++){
                if(k == l) continue;
                int sum = arr[k]-3*arr[l];
                if(!map.containsKey(sum)) continue;
                for(Pair current:map.get(sum)){
                    if(current.i == k || current.j == k || current.i == l || current.j == l) continue;
                    result.add(Arrays.asList(current.i,current.j,k,l));
                }
            }
        }
        System.out.println(result);
    }
}