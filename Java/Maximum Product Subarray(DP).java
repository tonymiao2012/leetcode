public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int res = nums[0], min = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curMin = min;
            min = Math.min(Math.min(nums[i], nums[i] * min), nums[i] * max);
            max = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * curMin);
            res = Math.max(res, max);
        }
        
        return res;
    }
}