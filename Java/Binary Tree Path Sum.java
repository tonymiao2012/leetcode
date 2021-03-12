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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public ArrayList<ArrayList<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }       
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(res, list, root, 0, target);
        
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, 
                        TreeNode root, int prev, int target){
        int cur = root.val + prev;
        
        if(cur == target && root.left == null && root.right == null){
            res.add(new ArrayList(list));
            return;
        }
        if(root.left != null){
            list.add(root.left.val);
            helper(res, list, root.left, cur, target);
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            list.add(root.right.val);
            helper(res, list, root.right, cur, target);
            list.remove(list.size() - 1);
        }

    }
}
