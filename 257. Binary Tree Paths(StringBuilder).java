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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return result;
        }   
        
        helperDFS(root, result, sb);
        return result;
    }
    private void helperDFS(TreeNode root, List<String> list, StringBuilder sb){
        if(root == null){
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            //Termination of one path.
            list.add(sb.toString());
        }else{
            sb.append("->");
            helperDFS(root.left, list, sb);
            helperDFS(root.right, list, sb);
        }
        sb.setLength(len);
    }
}