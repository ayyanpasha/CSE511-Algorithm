import java.util.*;
public class subarrayCount0{
    public static void main(String args[]){
        int arr[] = {0,3,-2,-1,3,5,6,5,-3,-4,2};
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int a:arr){
            sum += a;
            //sum-balance = 0 -> sum = balance
            int balance = sum;
            if(map.containsKey(balance)){
                count += map.get(map.get(balance));
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(count);
    }
}