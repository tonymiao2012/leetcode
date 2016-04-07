public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 0 || k > nums.length){
            return -1;
        }   
        return selectSort(nums, 0, nums.length - 1, nums.length - k);
    }
    public int selectSort(int[] nums, int start, int end, int k){
        if(start > end){
            return Integer.MAX_VALUE;
        }
        int left = start, pivot = nums[end];
        for(int i = start; i < end; i++){
            if(nums[i] <= pivot){
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        if(left > k){
            return selectSort(nums, start, left - 1, k);
        }
        if(left < k){
            return selectSort(nums, left + 1, end, k);
        }
        
        return nums[left];
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}