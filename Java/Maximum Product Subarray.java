public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        //boolean visited = new boolean[nums.length];
        
        int maxPre = nums[0];
        int minPre = nums[0];
        int maxResult = nums[0];
        int maxHere, minHere;
        
        for(int i = 1; i < nums.length; i++){
            maxHere = Math.max(Math.max(nums[i] * maxPre, nums[i] * minPre),nums[i]);
            minHere = Math.min(Math.min(nums[i] * maxPre, nums[i] * minPre),nums[i]);
            maxResult = Math.max(maxHere,maxResult);
            
            maxPre = maxHere;
            minPre = minHere;
        }
        
        return maxResult;
    }
}