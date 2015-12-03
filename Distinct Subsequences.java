public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        
        if(m < n){
            return 0;
        }
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                //Both empty
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    //S is empty, cannot form a string
                    dp[i][j] = 0;
                }else if(j == 0){
                    //T is empty, S is not empty.
                    dp[i][j] = 1;
                }else{
                    if(S.charAt(i - 1) == T.charAt(j - 1)){
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
