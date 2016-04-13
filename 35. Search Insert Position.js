/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    var i = 0, len = nums.length;
    if(nums){
        while(i < len){
            if(nums[i] === target){
                return i;
            }
            if(nums[i] > target){
                if(i === 0){
                    return 0;
                }else{
                    return i;
                }
            }
            i++;
        }
        
        return len;
    }
};