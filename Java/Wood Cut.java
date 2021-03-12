public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0){
            return 0;
        }
        int lb = 0, ub = Integer.MAX_VALUE;
        for(int l : L){
            if(l > ub){
                ub = l + 1;
            }
        }
        while(lb + 1 < ub){
            int mid = lb + (ub - lb) / 2;
            if(compare(L, k, mid)){
                lb = mid;
            }else{
                ub = mid;
            }
        }
        
        return lb;
    }
    public boolean compare(int[] L, int k, int i){
        int sum = 0;
        for(int l : L){
            sum += l / i;
        }
        
        return sum >= k;
    }
}