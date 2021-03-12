public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    //brutal way. O(N)
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i : num){
            if(i < min){
                min = i;
            }
        }
        
        return min;
    }

    //O(logN).
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
        int start = 0, end = num.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(num[mid] > num[end]){
                start = mid;
            }else if(num[mid] < num[end]){
                end = mid;
            }else{
                end--;
            }
        }
        
        if(num[start] < num[end]){
            return num[start];
        }else{
            return num[end];
        }
    }
}
}