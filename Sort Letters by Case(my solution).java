public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0){
            return;
        }
        int start = 0, end = chars.length - 1;
        while(start < end){
            if(Character.isLowerCase(chars[end]) && Character.isUpperCase(chars[start])){
                swap(chars, start, end);
                start++;
                end--;
            }
            if(Character.isLowerCase(chars[start])){
                start++;
            }
            if(Character.isUpperCase(chars[end])){
                end--;
            }
        }
    }
    
    private void swap(char[] chars, int a, int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
