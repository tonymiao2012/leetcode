public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if(s == null || s.length() == 0){
            return true;
        }
        int maxLen = getMaxLength(dict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            dp[i] = false;
            for(int lastWordLen = 1; 
                lastWordLen <= maxLen && lastWordLen <= i;
                lastWordLen++){
                    if(!dp[i - lastWordLen]){
                        continue;
                    }
                    String subStr = s.substring(i - lastWordLen, i);
                    if(dict.contains(subStr)){
                        dp[i] = true;
                        break;
                    }
                    
                }
        }
        
        return dp[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
