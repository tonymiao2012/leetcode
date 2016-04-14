/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                pre.next = cur1;
                cur1 = cur1.next;
            }else{
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        if(cur1 == null){
            pre.next = cur2;
        }else{
            pre.next = cur1;
        }
        return dummy.next;
        
    }
}