public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(B.length() == 0){
            return true;
        }
        if(A.length() == 0){
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : A.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        
        for(char tmp : B.toCharArray()){
            if(!map.containsKey(tmp) || map.get(tmp) == 0){
                return false;
            }else{
                map.put(tmp,map.get(tmp) - 1);
            }
        }
        
        return true;
    }
}
