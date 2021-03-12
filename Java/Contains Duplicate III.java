public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Math.abs(num[i] - num[j]) <= t and Math.abs(i - j <= k),O(kN) time complexity
        if (k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            Long floor = set.floor((long)nums[i]);
            Long ceil = set.ceiling((long)nums[i]);
            
            if((floor != null && nums[i] - floor <= t) || (ceil != null && ceil - nums[i] <= t))
                return true;
            set.add((long)nums[i]);
            
            //Deal with i - j > k case
            if(i > k)
                set.remove((long)nums[i - k - 1]);
        }
        
        return false;
    }
}