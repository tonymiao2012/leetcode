public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        if(nums.length == 0) return result;
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(target - nums[i],i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i){
                int index = map.get(nums[i]);
                if(index > i){
                    result[0] = i + 1;
                    result[1] = index + 1;
                }else{
                    result[0] = index + 1;
                    result[1] = i + 1;
                }
                break;
            }
        }
        
        return result;
    }
}