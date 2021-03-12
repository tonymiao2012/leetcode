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
        if(root == null || (A == null || B == null)){
            return null;
        }else if(A == null || B == null){
            return A == null ? B : A;
        }
        ArrayList<ParentTreeNode> listA = new ArrayList<>();
        ArrayList<ParentTreeNode> listB = new ArrayList<>();
        
        while(A != root){
            listA.add(0, A);
            A = A.parent;
        }
        listA.add(0, A);
        
        while(B != root){
            listB.add(0, B);
            B = B.parent;
        }
        listB.add(0, B);
        
        int size = Math.min(listA.size(), listB.size());
        for(int i = 0; i < size; i++){
            if(listA.get(i) != listB.get(i)){
                return listA.get(i).parent;
            }
        }
        
        return listA.get(size - 1);
    }
}

