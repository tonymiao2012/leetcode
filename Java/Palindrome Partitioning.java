public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        dfsHelper(s, path, 0, result);
        
        return result;
    }
    private void dfsHelper(String s, ArrayList<String> path, int pos, ArrayList<ArrayList<String>> result){
        if(pos == s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }
        for(int i = pos; i < s.length(); i++){
            String tmp = s.substring(pos, i + 1);
            if(!isPalindrome(tmp)){
                continue;
            }
            
            path.add(tmp);
            dfsHelper(s, path, i + 1, result);
            path.remove(path.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}