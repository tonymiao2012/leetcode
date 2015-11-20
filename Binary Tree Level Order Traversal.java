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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        
        return result;
        
    }
    
    private void helper(TreeNode root, int level, ArrayList<ArrayList<Integer>> result){
        if(root == null){
            return;
        }
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }
}
