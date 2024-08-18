//leetcode link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for(int price:prices){
            if(min>price){
                min = price;
            }else if(price-min>result){
                result = price-min;
            }
        }
        return result;
    }
}