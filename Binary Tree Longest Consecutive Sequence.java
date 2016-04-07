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
    public int longestConsecutive(TreeNode root){
        if(root == null){
            return 0;
        }
        return helper(root, 1);
    }
    private int helper(TreeNode root, int num){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return num;
        }
 
        int left, right;
        if(root.left != null && root.val + 1 == root.left.val){
            left = helper(root.left, num + 1);
        }else if(root.left == null){
            left = helper(root.left, num);
        }else{
            left = helper(root.left, 1);    //if root.val + 1 != left.val or right.val, current sum will be set to 1.
        }

        if(root.right != null && root.val + 1 == root.right.val){
            right = helper(root.right, num + 1);
        }else if(root.right == null){
            right = helper(root.right, num);
        }else{
            right = helper(root.right, 1);    //Same as above.
        }

        return Math.max(Math.max(left, right), num);    //Need to compare with current root.val. See      case[2, null, 3, 2, null, 1]
    }
}