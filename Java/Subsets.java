class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        for(int i = 0; i <= nums.length; i++){
            helper(result, i, nums, tmp, 0);
        }
        
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, int len, int[] nums, ArrayList<Integer> tmp, int index){
        if(tmp.size() == len){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }else if(index == nums.length){
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            int n = nums[i];
            tmp.add(n);
            helper(res, len, nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
