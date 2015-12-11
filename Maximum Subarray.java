public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        //Prefix sum
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int minSum = 0, preSum = 0;
        for(int i = 0; i < len; i++){
            preSum += nums[i];
            max = Math.max(max, preSum - minSum);
            minSum = Math.min(minSum, preSum);
        }
        return max;
    }
}