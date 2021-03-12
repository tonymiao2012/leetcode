class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int indexA = m - 1, indexB = n - 1, total = m + n - 1;
        while(indexA >= 0 && indexB >= 0){
            if(A[indexA] >= B[indexB]){
                A[total] = A[indexA];
                indexA--;
            }else{
                A[total] = B[indexB];
                indexB--;
            }
            total--;
        }
        
        if(indexA > 0){
            while(indexA >= 0){
                A[total] = A[indexA];
                indexA--;
                total--;
            }
        }else{
            while(indexB >= 0){
                A[total] = B[indexB];
                indexB--;
                total--;
            }
        }
    }
}