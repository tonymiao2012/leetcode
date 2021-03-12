class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int[] dp = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            int curMax = Math.max(dp[i - 1], prices[i] - prices[i - 1] + dp[i - 1]);
            dp[i] = curMax;
        }
        
        return dp[dp.length - 1];
    }
};