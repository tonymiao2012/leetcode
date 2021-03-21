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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    private ListNode findMiddle(ListNode head){
        ListNode slow = head; 
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.val >= head2.val){
                tail.next = head2;
                head2 = head2.next;
            }else{
                tail.next = head1;
                head1 = head1.next;
            }
            tail = tail.next;
        }
        if(head1 == null){
            tail.next = head2;
        }else{
            tail.next = head1;
        }
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left,right);
    }
}
