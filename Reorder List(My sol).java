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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode first = head;
        int index = 1;
        
        while(first.next != null){
            index++;
        }
        first = head;
        
        while(first.next != null){
            ListNode last = first.next;
            ListNode preLast = first;
            while(last.next != null){
                last = last.next;
                preLast = preLast.next;
            }
            pre.next = first;
            first = first.next;
            preLast.next = null;
            pre.next.next = last;
            pre = last;
        }
        
        if(index % 2 != 0){
            pre.next = first;
        }
    }
}
