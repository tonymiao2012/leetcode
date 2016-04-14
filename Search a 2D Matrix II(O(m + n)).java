public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        //Start from right-top item.
        int count = 0, row = 0, col = matrix[0].length - 1;
        while(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length){
            if(matrix[row][col] == target){
                count++;
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        
        return count;
    }
    

}
