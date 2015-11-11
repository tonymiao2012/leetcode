public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        
        int end = A.length - 1;
        int i = 0;
        while(i <= end){
            if(A[i] == elem){
                A[i] = A[end];
                end--;
            }else{
                i++;
            }
        }
        
        return end + 1;
    }
}

