public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if(A == null || A.length == 0 || k > A.length){
            return null;
        }
        int[] res = new int[k];
        //find first place >= target
        int right = findFirstLarger(A,target);
        //populate
        int left = right - 1;
        for(int i = 0; i < k; i++){
            if(left < 0){
                res[i] = A[right++];
            }else if(right >= A.length){
                res[i] = A[left--];
            }else{
                if(A[right] - target < target - A[left]){
                    res[i] = A[right++];
                }else{
                    res[i] = A[left--];
                }
            }    
        }
        
        return res;
    }
    
    private int findFirstLarger(int[] A, int target){
        int start = 0, end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        } 
        if(A[start] >= target){
            return start;
        }
        return end;
    }
}