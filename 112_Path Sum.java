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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val + sum;
        }
        sum = (sum + root.val) * 10;
        
        return helper(root.left, sum) + helper(root.right, sum);
    }
}
        }
        //Down to bottom.
        if(root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }
        
        return hasPathSum(root.left, sum - root.val) || 
               hasPathSum(root.right, sum - root.val);
    }
}