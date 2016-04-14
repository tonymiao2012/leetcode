public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0 ||
           (A.length == 1 && A[0] != target)){
            return false;
        }
        int i = 1;
        while(i < A.length){
            if(A[i - 1] > A[i]) break;
            i++;
        }
        
        int start, end;
        if(A[0] == target){ //Deal with duplication from the beginning.
            return true;
        }
        else if(A[0] < target){
            start = 0;
            end = i - 1;
            
        }else{
            start = i;
            end = A.length - 1;
        }
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target){
                return true;
            }else if(A[mid] > target){
                end = mid;
                while(end - 1 > start && A[end - 1] == A[end]){
                    end--;
                }
            }else{
                start = mid;
                while(start + 1 < end && A[start + 1] == A[start]){
                    start++;
                }
            }
        }
        if(A[start] == target || A[end] == target){
            return true;
        }
        
        return false;
    }
}
