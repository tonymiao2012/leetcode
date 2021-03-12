public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            int maxSub = 1;
            for(int j = i; j < nums.length; j++){
                if(nums[j] >= nums[i]){
                    maxSub = Math.max(maxSub, dp[j] + 1);
                }
                dp[i] = maxSub;
            }
        }
        
        Arrays.sort(dp);
        
        return dp[dp.length - 1];
    }
}

