class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    //One line solution
    public int sqrt(int x) {
        // write your code here
        return (int)Math.sqrt((double)x);
    }

    //二分法
    class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x <= 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        
        long start = 0, end = (long)x;
        while(start + 1 < end){
            long mid = start + (end - start) / 2;
            if(mid * mid == x){
                return (int)mid;
            }
            if(mid * mid < x){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        return (int)start;
    }
}
}