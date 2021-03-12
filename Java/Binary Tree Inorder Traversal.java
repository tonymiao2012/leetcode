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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        helper(root, res);
        
        return res;
    }
    
    private void helper(TreeNode root, ArrayList<Integer> res){
        if(root == null){
            return;
        }
        
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}