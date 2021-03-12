public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    private int n;
    private int[][] minSum;
    private int[][] triangle;
     
    private int search(int x, int y){
        if(x >= n){
            return 0;
        }
        if(minSum[x][y] != Integer.MAX_VALUE){
            return minSum[x][y];
        }
        
        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle[x][y];
        
        return minSum[x][y];
    }
     
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle[0] == null || triangle.length == 0 || triangle[0].length == 0){
            return -1;
        }
        
        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return search(0, 0);
    }
}

