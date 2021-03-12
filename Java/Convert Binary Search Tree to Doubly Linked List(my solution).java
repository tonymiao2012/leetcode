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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    private DoublyListNode prev = null;
    private DoublyListNode listHead = null;
    private DoublyListNode listTail = null;
    
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null){
            return null;
        }
        bstTraversal(root);
        
        return this.listHead;
    }
    
    private void bstTraversal(TreeNode root){
        if(root == null){
            return;
        }
        bstTraversal(root.left);
        
        DoublyListNode cur = new DoublyListNode(root.val);
        if(listHead == null){
            listHead = cur;
        }
        if(prev == null){
            prev = cur;
        }else{
            prev.next = cur;
            cur.prev = prev;
        }
        prev = cur;
        bstTraversal(root.right);
    }
}
