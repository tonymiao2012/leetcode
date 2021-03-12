/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int index = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, start, index - 1);
        root.right = helper(nums, index + 1, end);
        
        return root;
    }
}