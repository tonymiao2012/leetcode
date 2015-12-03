public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1 == null || s1.length() == 0){
            return s2.equals(s3);
        }
        
        if(s2 == null || s2.length() == 0){
            return s1.equals(s3);
        }
        
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len + s2Len != s3.length()){
            return false;
        }
        
        int index1 = 1;
        int index2 = 1;
        int index = 1;
        int last1 = -1;
        int last2 = -1;
        int last = -1;
        boolean trace = false;
        while(index < s3.length()){
            if(index1 == s1Len && index2 == s2Len){
                return true;
            }
            if(s1.charAt(index1 - 1) != s3.charAt(index - 1) && s2.charAt(index2 - 1) != s3.charAt(index - 1)){
                if(trace){
                    return false;
                }else{
                    index1 = last1;
                    index2 = last2++;
                    index = last++;
                    trace = true;
                    break;
                }
            }
            else if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1)){
                last1 = index1;
                last2 = index2;
                last = index;
            }
            else if(index1 < s1Len && s1.charAt(index1 - 1) == s3.charAt(index - 1)){
                index1++;
            }
            else if(index2 < s2Len && s2.charAt(index2 - 1) == s3.charAt(index - 1)){
                index2++;
            }
            index++;
        }
        
        return true;
    }
}


    public static void main(String[] args) {
        String s1 = "sdfjas;dfjoisdufzjkndfasdkfja;sdfa;dfa;dfaskdjhfasdhjdfakhdgfkajdfasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfhakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh";
        String s2 = "dfnakdjnfjkzghdufguweygfasjkdfgb2gf8asf7tgbgasjkdfgasodf7asdgfajksdfguayfgaogfsdkagfsdhfajksdvfbgkadsghfakdsfgasduyfgajsdkfgajkdghfaksdgfuyadgfasjkdvfjsdkvfakfgauyksgfajkefgjkdasgfdjksfgadjkghfajksdfgaskdjfgasjkdgfuyaegfasdjkfgajkdfygadjskfgjkadfg";
        String s3 = "sdfjas;dfjoisdfnakdjnfjkzghdufguwdufzjkeygfasjkdfgb2gf8asf7ndtgbgasjkdfgasodf7asdfgfajkasdksdfguayfgaogfsdkagfsfjadhfajksdvfbgkadsghfa;sdkdsfgasduyfgajsdkfgafajkdghfaksdgfuyadgfas;dfjkdvfjsdkvfakfgauyksa;dgfajkefgjkdasgfdjksffaskdjhfasdhjdfakhdgadjkghfajgfkajdfksdfgaskdjfgasjkdgfuasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfyaegfasdjkfgajkdfygadjskfgjkadfghakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh";

        System.out.println(isInterleave(s1,s2,s3));
    }
}
