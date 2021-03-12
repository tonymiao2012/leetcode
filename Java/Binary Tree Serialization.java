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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        
        serializeHelper(root, sb);
        
        return sb.substring(0, sb.length() - 1);
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
        }else{
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    } 
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == null || data.length() == 0){
            return null;
        }
        StringTokenizer st = new StringTokenizer(data, ",");
        return deserializeHelper(st);
    }
    
    private TreeNode deserializeHelper(StringTokenizer st){
        if(!st.hasMoreTokens()){
            return null;
        }
        //The token pointer will be maintained. No worries about pre level root
        String s = st.nextToken();
        if(s.equals("#")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeHelper(st);
        root.right = deserializeHelper(st);
        
        return root;
    }
}
