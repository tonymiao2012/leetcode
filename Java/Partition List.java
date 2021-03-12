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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null){
            return head;
        }
        
        //Two dummy pointers. 
        ListNode dummy1 = new ListNode(-1); 
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1, cur2 = dummy2;
        
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        //Join lists.
        cur2.next = null;
        cur1.next = dummy2.next;
        
        return dummy1.next;
    }
}
