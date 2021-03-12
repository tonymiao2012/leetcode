public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(k);
        int sum = 0;
        helper(A, target, sum, k, 0, temp, result);
        
        return result;
    }
    private void helper(int[] A, 
                        int target, 
                        int sum,
                        int k,
                        int index,
                        ArrayList<Integer> temp, 
                        ArrayList<ArrayList<Integer>> result)
    {
        if(temp.size() == k){
            if(sum == target){
                result.add(new ArrayList(temp));
            }
            return;
        }
        for(int i = index; i < A.length; i++){
            temp.add(A[i]);
            sum += A[i];
            helper(A, target, sum, k, i + 1, temp, result);
            temp.remove(temp.size() - 1);
            sum -= A[i];
        }
    }
}