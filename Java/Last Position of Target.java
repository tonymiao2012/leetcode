public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int lb = 0, ub = A.length - 1;
        while(lb + 1 < ub){
            int mid = lb + (ub - lb) / 2;    
            if(A[mid] <= target){
                lb = mid;
            }else{
                ub = mid;
            }
        }
        
        if(A[ub] == target){
            return ub;
        }else if(A[lb] == target){
            return lb;
        }else{
            return -1;
        }
    }
}