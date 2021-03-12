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
 class resultType{
     boolean is_bst;
     int maxVal, minVal;
     
     resultType(boolean is_bst, int maxVal, int minVal){
         this.is_bst = is_bst;
         this.maxVal = maxVal;
         this.minVal = minVal;
     }
 }
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private resultType isValidHelper(TreeNode root) {
        // write your code here
        if(root == null){
            return new resultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        resultType left = isValidHelper(root.left);
        resultType right = isValidHelper(root.right);
        
        if(!left.is_bst || !right.is_bst){
            return new resultType(false, 0, 0);
        }
        
        if(root.left != null && left.maxVal >= root.val ||
            root.right != null && right.minVal <= root.val){
                return new resultType(false, 0, 0);
            }
            
        return new resultType(true, 
                              Math.max(root.val, right.maxVal), 
                              Math.min(root.val, left.minVal));
    }
    
    public boolean isValidBST(TreeNode root){
        resultType r = isValidHelper(root);
        return r.is_bst;
    }
    
}
