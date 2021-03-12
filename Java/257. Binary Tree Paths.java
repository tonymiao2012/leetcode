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
        List<String> tmp = new ArrayList<String>();
        if(root == null){
            return result;
        }   
        
        helperDFS(root, result, tmp);
        return result;
    }
    private void helperDFS(TreeNode root, List<String> list, List<String> tmp){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            //Termination of one path.
            tmp.add(String.valueOf(root.val));
            list.add(list_to_string(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        
        tmp.add(String.valueOf(root.val));
        tmp.add("->");
        helperDFS(root.left, list, tmp);
        helperDFS(root.right, list, tmp);
        tmp.remove(tmp.size() - 1);
        tmp.remove(tmp.size() - 1);
    }
    
    private static String list_to_string(List<String> tmp){
        String res = "";
        for(String s : tmp){
            res += s;
        }
        return res;
    }
}