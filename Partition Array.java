public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    
	    int start = 0, end = nums.length - 1;
	    while(start <= end){
	        if(nums[start] >= k){
	            if(nums[end] < k){
	                //SWAP(start,end)
	                int tmp = nums[start];
	                nums[start] = nums[end];
	                nums[end] = tmp;
	                start++;
	                end--;
	            }else{
	                while(start <= end && nums[end] >= k){
	                    end--;  
	                }
	            }
	        }else{
	            while(start <= end && nums[start] < k){
	                start++;
	            }
	        }
	    }
	    return start;
    }
}
