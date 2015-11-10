public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s.length() != t.length()){    
            return false;
        }
        
        if(s == "" && s.equals(t)){  
            return true;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(s.length() - 1 - i))
                return false;
        }
        
        return true;
    }

    void public static void main(String[] args) {
        String s = "ab";
        String t = "ab";

        boolean b = anagram(s,t);

        System.out.println(b);
    }
}