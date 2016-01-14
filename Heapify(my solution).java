public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for(int i = A.length / 2; i >= 0; i--){
            helper(A, i);
        }
    }
    private void helper(int[] A, int i){
        while(i < A.length){
            int min = i;
            if(2 * i + 1 < A.length && A[2 * i + 1] < A[min]){
                min = 2 * i + 1;
            }
            if(2 * i + 2 < A.length && A[2 * i + 2] < A[min]){
                min = 2 * i + 2;
            }
            
            if(min == i){
                break;
            }
            swap(min, i, A);
            //next loop
            i = min;
        }
    }
    
    private void swap(int a, int b, int[] A){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}