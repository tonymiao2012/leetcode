public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int max = 0;
        if(A.length() == 0 || B.length() ==0){
            return max;
        }
        int pre = 0;
        
        for(int i = 0; i < A.length(); i++){
            if(B.indexOf(A.charAt(i), pre) != -1){
                int k = 1;
                int curB = B.indexOf(A.charAt(i), pre);
                while(i + k < A.length() && curB + k < B.length()){
                    String subA = A.substring(i, i + k + 1);
                    String subB = B.substring(curB, curB + k + 1);
                    if(!subA.equals(subB)){
                        max = Math.max(k,max);
                        break;
                    }else{
                        k++;
                    }
                }
                
                if(curB + k < B.length()){
                    pre = curB + k + 1;
                }else{
                    break;
                }
            }
        }
        return max;
    }
}
