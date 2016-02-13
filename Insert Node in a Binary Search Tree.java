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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            return node;
        }
        TreeNode cur = root;
        while(cur.left != null || cur.right != null ){
            if(cur.val == node.val){
                return root;
            }
            else if(cur.val > node.val){
                if(cur.left != null){
                    cur = cur.left;
                    continue;
                }else{
                    cur.left = node;
                    return root;
                }
            }else{
                if(cur.right != null){
                    cur = cur.right;
                    continue;
                }else{
                    cur.right = node;
                    return root;
                }
            }
        }
        
        if(node.val > cur.val){
            cur.right = node;
        }else{
            cur.left = node;
        }
        return root;
    }
}