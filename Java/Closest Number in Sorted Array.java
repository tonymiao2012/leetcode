public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target){
                start = mid;
            }else if(A[mid] > target){
                end = mid;
            }else{
                return mid;
            }
        }
        
        if(Math.abs(A[end] - target) < Math.abs(A[start] - target)){
            return end;
        }else{
            return start;
        }
    }
}