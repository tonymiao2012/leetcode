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
    
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode first = null, second = null, prev = null, curr = root;
        
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                if(!stack.isEmpty()){
                    curr = stack.pop();
                    if(prev != null && prev.val >= curr.val){
                        if(first == null){
                            first = prev;
                        }
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }    
            }
        }
        
        //recover swapped nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
}