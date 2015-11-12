public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        int close = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(numbers);
        
        for(int i = 0; i < numbers.length - 1; i++){
            int start = i + 1;
            int end = numbers.length - 1;
            
            while(start < end){
                int tmpSum = numbers[i] + numbers[start] + numbers[end];
                int tmpClose = Math.abs(target - tmpSum);
                
                if(tmpClose == 0){
                    return tmpSum;
                }else if(tmpClose < close){
                    close = tmpClose;
                    sum = tmpSum;
                }
                
                if(tmpSum > target){
                    end--;
                }else{
                    start++;  
                }
            }
        }
        
        return sum;
    }
}

