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
     * @return: An integer.
     */
     
    public static int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        int cur = 1;
        helper(root, cur);
        
        return min;
    }
    
    private void helper(TreeNode root, int cur){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            min = Math.min(cur, min);
            return;
        }
        helper(root.left, cur + 1);
        helper(root.right, cur + 1);
    }
}