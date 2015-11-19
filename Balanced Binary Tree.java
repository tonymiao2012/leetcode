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
     * @return: True if this Binary tree is Balanced, or false.
     */
    private class resultType{
        public int level;
        public boolean is_bln;
        public resultType(int level, boolean is_bln){
            this.level = level;
            this.is_bln = is_bln;
        }
    }
     
    public boolean isBalanced(TreeNode root) {
        // write your code here
        resultType result = helper(root);
        return result.is_bln;
    }
    
    private resultType helper(TreeNode root){
        if(root == null){
            return new resultType(0, true);
        }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int curLevel = Math.abs(left.level - right.level);
        boolean isBalance = left.is_bln && right.is_bln;
        
        if(curLevel <= 1){
            return new resultType(Math.max(left.level, right.level) + 1, isBalance);
        }else{
            return new resultType(0, false);
        }
    }

}
