public class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++; end--;
                    while(start < end && nums[start] == nums[start - 1])    start++;
                    while(start < end && nums[end] == nums[end + 1])    end--;
                }else if(sum > 0){
                    end--;
                    while(start < end && nums[end] == nums[end + 1])    end--;
                }else{
                    start++;
                    while(start < end && nums[start] == nums[start - 1])    start++;
                }
            }
            while(i + 1 < nums.length && nums[i + 1] == nums[i])    i++;
        }
        
        return res;
    }
}