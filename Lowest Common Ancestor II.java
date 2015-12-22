/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here  
        if(root == null){
            return null;
        }
        if(root == root.left || root == root.right){
            return root;
        }
        //Divide 
        ParentTreeNode left = lowestCommonAncestorII(root.left, A, B);
        ParentTreeNode right = lowestCommonAncestorII(root.right, A, B);
        
        //Conquer
        if((left == A && right == B) ||
           (right == A && left == B) ||
           (left == A && root == B) ||
           (root == A && right == B)){
            if(root.parent != null){
               root.parent = root;
            }
        }else if(left == A){
            root = root.left;
        }else if(right == B){
            root = root.right;
        }
        return root;
    }
}

