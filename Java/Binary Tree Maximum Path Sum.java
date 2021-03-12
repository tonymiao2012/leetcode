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
     private class resultType{
         public int singlePath;
         public int maxPath;
         public resultType(int singlePath, int maxPath){
             this.singlePath = singlePath;
             this.maxPath = maxPath;
         }
     }
     
    private resultType helper(TreeNode root) {
        // write your code here
        if(root == null){
            return new resultType(0, Integer.MIN_VALUE);
        }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int curSingle = Math.max(left.singlePath + root.val, right.singlePath + root.val);
        curSingle = Math.max(curSingle, 0);
        
        int curMax = Math.max(left.maxPath, right.maxPath);
        curMax = Math.max(curMax, left.singlePath + root.val + right.singlePath);
        
        return new resultType(curSingle, curMax);
        
    }
    
    public int maxPathSum(TreeNode root){
        resultType result = helper(root);
        
        return result.maxPath;
    }
}
