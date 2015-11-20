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
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        
        //Divide 
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        int curMax = Math.max(left, right);

        return curMax + 1;
    }
}
