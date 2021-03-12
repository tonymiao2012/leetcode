public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(A == null || A.length == 0){
            return res;
        }
        int diff = 0;
        for(int i : A){
            diff ^= i;
        }
        diff = Integer.highestOneBit(diff);
        int num1 = 0, num2 = 0;
        for(int num : A){
            if((num & diff) == 0){
                num1 ^= num;
            }else{
                num2 ^= num;
            }
        }
        res.add(num1);
        res.add(num2);
        
        return res;
    }
}