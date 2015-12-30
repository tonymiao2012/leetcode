public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 * Time complexity: O(NlogN), Space complexity: O(1)
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        Arrays.sort(A);
        int i = 0;
        while(i < A.length - 1){
            if(A[i] == A[i + 1]){
                i += 3;
            }else{
                return A[i];
            }
        }
        
        return A[A.length - 1];
    }
}