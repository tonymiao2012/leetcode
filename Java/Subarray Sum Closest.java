public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    private class helper{
        int sum;
        int index;
        public helper(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }
     
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        //Prefix sum subarray.
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            int[] rst = new int[2];
            rst[0] = 0;
            rst[1] = 0;
            return rst;
        }
        
        helper[] sum = new helper[nums.length + 1];
        sum[0] = new helper(0,0);
        //Construct sum array
        int prev = 0;
        for(int i = 1; i < nums.length + 1; i++){
            sum[i] = new helper(prev + nums[i - 1], i);
            prev = sum[i].sum;
        }
        
        Arrays.sort(sum, new Comparator<helper>(){
            public int compare(helper a, helper b){
                return a.sum - b.sum;
            }
        });
        
        int interval = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(int i = 1; i < sum.length; i++){
            if(interval > sum[i].sum - sum[i - 1].sum){
                interval = sum[i].sum - sum[i - 1].sum;
                result[0] = sum[i].index - 1;
                result[1] = sum[i - 1].index - 1;
            }
        }
        Arrays.sort(result);
        result[0] += 1;
        return result;
    }
}
