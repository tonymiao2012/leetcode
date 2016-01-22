public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            int k = Arrays.binarySearch(matrix[i], target);
            if(k >= 0){
                count++;
            }
        }
        
        return count;
    }
    

}
