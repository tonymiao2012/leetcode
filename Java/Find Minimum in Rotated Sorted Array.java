public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        if(num.length == 1){
            return num[0];
        }
        
        int i = 1;
        while(i < num.length){
            if(num[i - 1] > num[i]){
                if(i + 1 < num.length && num[i] < num[i + 1]){
                    return num[i];
                }
            }else if(num[i - 1] < num[i]){
                if(i + 1 < num.length && num[i] > num[i + 1]){
                    return num[i + 1];
                }
            }
            i++;
        }
        
        if(num[0] < num[num.length - 1]){
            return num[0];
        }else{
            return num[num.length - 1];
        }
    }
}
