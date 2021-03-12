public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] dp = new int[m][n];
        int r = 0;
        while(r < m){
            if(obstacleGrid[r][0] != 1){
                dp[r][0] = 1;
            }else{
                break;
            }
            r++;
        }
        
        r = 0;
        while(r < n){
            if(obstacleGrid[0][r] != 1){
                dp[0][r] = 1;
            }else{
                break;
            }
            r++;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
