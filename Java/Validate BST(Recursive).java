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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     * Recursive
     */
    private boolean isValidHelper(TreeNode root, long min, long max) {
        // write your code here
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        
        return isValidHelper(root.left, min, root.val) && isValidHelper(root.right, root.val, max);
    }
    
    public boolean isValidBST(TreeNode root){
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
}
