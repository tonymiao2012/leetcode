public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     * Time complexity: O(N) Space complexity: O(1)
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int key1 = 0, count1 = 0;
        int key2 = 0, count2 = 0;
        for(int num : nums){
            if(count1 == 0){
                key1 = num;
                count1 = 1;
                continue;
            }else if(count2 == 0 && num != key1){
                key2 = num;
                count2 = 1;
                continue;
            }
            if(key1 == num){
                count1++;
            }else if(key2 == num){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0; 
        count2 = 0;
        for(int num : nums){
            if(num == key1){
                count1++;
            }
            if(num == key2){
                count2++;
            }
        }
        
        return count1 > count2 ? key1 : key2;
    }
}
