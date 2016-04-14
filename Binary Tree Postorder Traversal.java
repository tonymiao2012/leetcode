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
     * @return: Postorder in ArrayList which contains node values.
     * recursion
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
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
        helper(root.right, res);
        res.add(root.val);
    }
}

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
     * @return: Postorder in ArrayList which contains node values.
     * iteration
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        TreeNode pre = null;
        while(!s.isEmpty()){
            TreeNode cur = s.peek();
            boolean noChild = (cur.left == null && cur.right == null);
            boolean childVisited = false;
            if(pre != null && (cur.left == pre || cur.right == pre)){
                childVisited = true;    
            }
            if(noChild || childVisited){
                res.add(cur.val);
                s.pop();
                pre = cur;
            }else{
                if(cur.right != null)   s.push(cur.right);
                if(cur.left != null)    s.push(cur.left);
            }
        }
        
        return res;
    }
}