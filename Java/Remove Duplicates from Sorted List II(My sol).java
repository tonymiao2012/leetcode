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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy,post,cur = head;
        
        while(cur != null && cur.next != null){
            if(cur.next.val == cur.val){
                while(cur.next.val == cur.val){
                    cur = cur.next;
                }
                post = cur.next;
                pre.next = post;
                cur.next = null;
                cur = post;
            }
            if(cur == null || cur.next == null){
                break;
            }
            pre = cur;
            cur = cur.next;
            
        }
        
        return dummy.next;
    }
}
