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
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if(root == null){
            return true;
        }
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        left.offer(root.left);
        right.offer(root.right);
        TreeNode tempL = null;
        TreeNode tempR = null;
        
        while(!left.isEmpty() && !right.isEmpty()){
            tempL = left.poll();
            tempR = right.poll();
            if(tempL == null && tempR == null){
                continue;
            }
            
            if((tempL == null && tempR != null) || 
               (tempL != null && tempR == null) ||
               (tempL.val != tempR.val)){
                return false;
            }
            //Update
            left.offer(tempL.right);
            left.offer(tempL.left);
            right.offer(tempR.left);
            right.offer(tempR.right);
        }
        
        return true;
    }
}