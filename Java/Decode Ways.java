//LeetCode #91

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s== null || s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int num = Integer.parseInt(s.substring(i - 2, i));
            int twoSteps = (num > 9 && num < 27) ? dp[i - 2] : 0;
            int oneStep = (Integer.parseInt(s.substring(i - 1, i)) != 0) ? dp[i - 1] : 0;
            
            dp[i] = twoSteps + oneStep;
        }
        
        return dp[n];
    }
}