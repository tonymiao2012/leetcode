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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(n <= 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDel = dummy;
        
        //First pointer move N
        while(n > 0){
            if(head == null){
                return null;
            }
            head = head.next;
            n--;
        }
        //Move together
        while(head != null){
            head = head.next;
            preDel = preDel.next;
        }
        
        //Remove Kth node.
        preDel.next = preDel.next.next;
        
        return dummy.next;
    }
}

