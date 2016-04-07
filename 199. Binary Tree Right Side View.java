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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        helper(root, result, 1);
        
        return result;
    }
    private void helper(TreeNode root, List<Integer> list, int lvl){
        if(root == null){
            return;
        }
        if(list.size() < lvl){
            list.add(root.val);
        }
        helper(root.right, list, lvl + 1);
        helper(root.left, list, lvl + 1);
    }
}