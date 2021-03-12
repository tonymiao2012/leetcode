public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        //dp means min steps to current index.
        int[] dp = new int[A.length];
        dp[0] = 0;
        
        for(int i = 1; i < A.length; i++){
            dp[i] = Integer.MAX_VALUE; 
            for(int j = 0; j < i; i++){
                if(dp[j] != Integer.MAX_VALUE && j + A[j] >= i){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        
        return dp[A.length - 1];
    }
}

