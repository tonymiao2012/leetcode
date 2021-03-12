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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        //Use divide and conquer
        if(root == null){
            return 0;
        }
        int sumLeft = maxPathSum2(root.left);
        int sumRight = maxPathSum2(root.right);
        int rootVal = root.val;
        int curMax = Math.max(sumLeft + rootVal, sumRight + rootVal);
        if(rootVal + sumLeft <= rootVal){
            sumLeft = 0;
        }else if(rootVal + sumRight <= rootVal){
            sumRight = 0;
        }
        
        return curMax;
    }
}
