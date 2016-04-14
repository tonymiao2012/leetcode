public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums == null || nums.isEmpty()) return -1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        
        int key = 0, max = Integer.MIN_VALUE;
        for(int kk : map.keySet()){
            if(map.get(kk) > max){
                max = map.get(kk);
                key = kk;
            }
        }
        
        return key;
    }
}
