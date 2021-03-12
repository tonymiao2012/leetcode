public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int head = 0, tail = 0;
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(A[start] == target){
            head = start;
        }else if(A[end] == target){
            head = end;
        }else{
            head = -1;
        }
        
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(A[end] == target){
            tail = end;
        }else if(A[start] == target){
            tail = start;
        }else{
            tail = -1;
        }
        
        if(head >= 0 && tail >= 0){
            return tail - head + 1;
        }else{
            return 0;
        }
    }
}
