public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        if(str == null || str.length() == 0){
            ArrayList<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] exist = new boolean[str.length()];
        int len = str.length();
        helper(str, sb, len, exist, set);
        
        ArrayList<String> result = new ArrayList<String>(set);
        
        return result;
    }
    
    private void helper(String str,
                        StringBuilder sb,
                        int len, 
                        boolean[] exist, 
                        HashSet<String> set){
        if(sb.length() == len){
            String tmp = sb.toString();
            set.add(tmp);
            return;
        }
        
        for(int i = 0; i < len; i++){
            if(exist[i]){
                continue;
            }
            exist[i] = true;
            sb.append(str.charAt(i));
            helper(str, sb, len, exist, set);
            sb.deleteCharAt(sb.length() - 1);
            exist[i] = false;
        }
    }
}