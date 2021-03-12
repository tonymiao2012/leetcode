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
        if(nums.length == 1){
            return nums[0];
        }
        int[] product = new int[nums.length];
        int max = Integer.MIN_VALUE, k = 1;
        product[0] = nums[0];
        while(k < nums.length){
            product[k] = nums[k] * product[k - 1];
        }
        
        for(int i = 0; i < product.length; i++){
            for(int j = i; j < product.length; j++){
                int tmp = product[j] / product[i];
                max = Math.max(max, tmp);
            }
        }
        
        return max;
    }
}