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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     * Time complexity: O(n^2) space: O(1);
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || inorder == null) return null;
        if(preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length != inorder.length)   return null;
        int len = preorder.length - 1;
        TreeNode root = helper(preorder, inorder, 0, len, 0, len);
        return root;
    }
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, 
                            int inStart, int inEnd){
        //corner case
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        //build node
        TreeNode node = new TreeNode(preorder[preStart]);
        //find index for next recursion
        int index = findIndex(inorder, inStart, inEnd, preorder[preStart]);
        node.left = helper(preorder, inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        node.right = helper(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);
        //return root
        return node;   
    }
    
    private int findIndex(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}