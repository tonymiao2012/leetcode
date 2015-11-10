class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null){
            return -1;
        }
        int srcLen = source.length(), tgtLen = target.length();
        if(tgtLen > srcLen){
            return -1;
        }
        if(target == ""){
            return 0;
        }
        
        for(int i = 0; i < srcLen; i++){
            if(source.charAt(i) == target.charAt(0)){
                if(i + tgtLen - 1 < srcLen){
                    String subStr = source.substring(i, i + tgtLen);
                    if(subStr.equals(target)){
                        return i;
                    }
                }
            }
        }
        
        return -1;
    }
}
