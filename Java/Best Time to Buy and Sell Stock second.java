public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int minProfit = prices[0], max = 0;
        for(int i = 0; i < prices.length; i++){
            minProfit = Math.min(prices[i], minProfit);
            max = Math.max(max, prices[i] - minProfit);
        }
        return max;
    }
}