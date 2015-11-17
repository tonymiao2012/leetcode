public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0 || target <= A[0]){
            return 0;
        }
        if(target > A[A.length - 1]){
            return A.length;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(target < A[start]){
            return start;
        }else if(target > A[end]){
            return end + 1;
        }
        return end;
    }
}

