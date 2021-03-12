public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if(A.charAt(i - 1) == B.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}

