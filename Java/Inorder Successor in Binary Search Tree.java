/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        TreeNode successor = null;
        TreeNode cur = root;
        while(cur != null && cur.val != p.val){
            if(cur.val < p.val){
                cur = cur.right;
            }else if(cur.val > p.val){
                successor = cur;
                cur = cur.left;
            }
        }
        
        if(cur == null){
            return null;
        }
        if(cur.right == null){
            return successor;
        }
        
        cur = cur.right;
        while(cur.left != null){
            cur = cur.left;
        }
        
        return cur;
    }
    
}
