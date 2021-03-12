class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null || nums.size() == 0){
            return res;
        }
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        BitSet set = new BitSet(nums.size());
        helper(tmp, res, nums, set);
        
        return res;
    }
    
    private void helper(ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums, BitSet set){
        if(tmp != null && tmp.size() == nums.size()){
            ArrayList<Integer> temp = new ArrayList<Integer>(tmp);
            result.add(temp);
            tmp = new ArrayList<Integer>();
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(!set.get(i)){
                set.set(i, true);
                tmp.add(nums.get(i));
                helper(tmp, result, nums, set);
                tmp.remove(tmp.size() - 1);
                set.flip(i);
            }
        }
    }
}