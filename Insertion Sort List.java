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
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);;
        ListNode cur = head;
        
        while(cur != null){
            ListNode pre = dummy;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
        }
        
        return dummy.next;
        
    }
}