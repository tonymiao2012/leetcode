public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int key = -1, count = 0;
        for(int num : nums){
            if(count == 0){
                key = num;
                count = 1;
                continue;
            }
            
            if(key == num){
                count++;
            }else{
                count--;
            }
        }
        return key;
    }
}