public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int h = height(root);
        return h == -1 ? false : true;
    }
    
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        if(lh == -1){
            return -1;
        }
        int rh = height(root.right);
        if(rh == -1){
            return -1;
        }
        
        if(rh - lh > 1 || rh - lh < -1){
            return -1;
        }
        return Math.max(rh, lh) + 1;
    }
}