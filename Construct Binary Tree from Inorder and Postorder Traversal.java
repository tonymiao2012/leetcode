/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     * Time complexity:O(n^2) Space Complexity:O(1)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || postorder == null)    return null;
        if(inorder.length == 0 || postorder.length == 0)    return null;
        int len = inorder.length - 1;
        TreeNode root = helper(inorder, 0, len, postorder, 0, len);
        return root;
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }               
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = findIndex(inorder, inStart, inEnd, postorder[postEnd]);
        
        root.left = helper(inorder, inStart, index - 1, postorder, postStart, postEnd - inEnd + index - 1);
        root.right = helper(inorder, index + 1, inEnd, postorder, postEnd - inEnd + index, postEnd - 1);
        
        return root;
    }
    
    private int findIndex(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}