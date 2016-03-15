public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int curMax = 0, curMin = prices[0], sum = 0;
        int i = 0;
        while(i < prices.length){
            //find curMax within a range.
            int index = 0;
            for(int j = i; j < prices.length; j++){
                curMax = Math.max(curMax, prices[j]);
                if(j + 1 < prices.length && prices[j + 1] < prices[j]){
                    index = j + 1;
                    break;
                }else if(j + 1 == prices.length){
                    index = prices.length - 1;
                    break;
                }
            }
            sum += curMax - curMin;
            //update curMin.
            curMin = prices[index];
            i = index;
        }
        
        return sum;
    }
}