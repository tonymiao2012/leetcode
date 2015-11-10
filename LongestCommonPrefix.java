public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        String res = "";
        if (strs.length == 0){
            return res;
        }
        
        //O(M*N) compare.
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++){
            for (String s : strs){
                if(s.length() == 0){
                    return res;
                }
                else if (s.charAt(i) != strs[0].charAt(i) || i >= s.length()){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
