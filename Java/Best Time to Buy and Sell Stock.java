public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int max = 0, minSum = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minSum = Math.min(minSum, prices[i]);
            max = Math.max(max, prices[i] - minSum);
        }
        return max;
    }
}