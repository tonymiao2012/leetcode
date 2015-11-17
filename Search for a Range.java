public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] bound = {-1, -1};
        if(A == null || A.length == 0){
            return bound;
        }
        int start,end,mid;
        
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            mid = (start + end) / 2;
            if(A[mid] < target){
                start = mid;
            }
            else if(A[mid] > target){
                end = mid;
            }else{
                end = mid;
            }
        }
        if(A[start] == target){
            bound[0] = start;
        }else if(A[end] == target){
            bound[0] = end;
        }else{
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            mid = (start + end) / 2;
            if(A[mid] == target){
                start = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[end] == target){
            bound[1] = end;
        }else if(A[start] == target){
            bound[1] = start;
        }else{
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
        
    }
}

