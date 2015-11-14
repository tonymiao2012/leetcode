public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null){
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            if(sum == 0){
                result.add(i);
                result.add(i);
                return result;
            }
            int j = i + 1;
            while(j < nums.length){
                //Find all subarrays
                sum += nums[j];
                if(sum == 0){
                    result.add(i);
                    result.add(j);
                    return result;
                }
                j++;
            }
        }
        
        return result;
    }
}
