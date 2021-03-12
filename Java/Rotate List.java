/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        //get len first
        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        k %= len;
        
        ListNode prev = head;
        cur = head;
        int i = 0;
        while(i < k){
            if(cur == null){
                return head;
            }
            cur = cur.next;
            i++;
        }
        while(cur.next != null){
            prev = prev.next;
            cur = cur.next;
        }
        
        ListNode newHead = prev.next;
        cur.next = head;
        prev.next = null;
        
        return newHead;
    }
}