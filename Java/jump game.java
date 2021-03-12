public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0){
            return false;
        }
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && A[j] + j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[A.length - 1];
        
    }
}

