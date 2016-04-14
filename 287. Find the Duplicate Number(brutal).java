public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }   
        int duplication = 0;
        for(int i = 0, j = nums.length; i < j; i++){
            int tmp = nums[i];
            for(int k = i + 1; k < j; k++){
                if(nums[k] == tmp){
                    return nums[k];
                }
            }
        }
        
        return -1;
    }
}