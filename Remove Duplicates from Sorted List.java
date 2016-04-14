/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        
        while(pre.next.next != null){
            if(pre.next.val == pre.next.next.val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        if(pre.val == pre.next.val){
            pre.next = null;
        }
        
        return dummy.next;
    }  
}