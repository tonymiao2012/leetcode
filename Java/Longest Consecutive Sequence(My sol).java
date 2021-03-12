public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0){
            return 0;
        }
        if(num.length == 1){
            return 1;
        }
        Arrays.sort(num);
        int max = Integer.MIN_VALUE, curMax = 1;
        for(int i = 1; i < num.length; i++){
            if(num[i - 1] == num[i]){
                continue;
            }else if(num[i - 1] + 1 == num[i]){
                curMax++;
                continue;
            }else{
                max = Math.max(max, curMax);
                curMax = 1;
            }
        }
        
        return Math.max(max,curMax);
    }
}