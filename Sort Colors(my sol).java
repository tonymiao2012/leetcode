class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        
        TreeMap<Integer,Integer> colors = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(colors.containsKey(nums[i])){
                int tmp = colors.get(nums[i]);
                tmp = tmp + 1;
                colors.put(nums[i], tmp);
            }else{
                colors.put(nums[i], 1);
            }
        }
        
        int index = 0;
        for(Integer i : colors.keySet()){
            int curLen = colors.get(i);
            while(curLen > 0){
                nums[index] = i;
                index++;
                curLen--;
            }
        }
        
    }
}