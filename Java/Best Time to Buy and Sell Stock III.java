class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        //Divide and conquer
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[] profitFront = new int[len];
        int[] profitBack = new int[len];
        int valley = prices[0], peak = prices[len - 1];
        
        for(int i = 1; i < len; i++){
            profitFront[i] = Math.max(profitFront[i - 1], prices[i] - valley);
            valley = Math.min(valley, prices[i]);
        }
        
        for(int i = len - 2; i >= 0; i--){
            profitBack[i] = Math.max(profitBack[i + 1], peak - prices[i]);
            peak = Math.max(peak, prices[i]);
        }
        int profit = 0;
        for(int i = 0; i < len; i++){
            profit = Math.max(profit, profitBack[i] + profitFront[i]);
        }
        
        return profit;
    }
};