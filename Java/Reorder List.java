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
     private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        
        return newHead;
    }
    
    private void merge(ListNode head1, ListNode head2){
        int index = 0;
        ListNode dummy = new ListNode(-1);
        while(head1 != null && head2 != null){
            if(index % 2 == 0){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index++;
        }
        if(head1 != null){
            dummy.next = head1;
        }else{
            dummy.next = head2;
        }
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    } 
     
    public void reorderList(ListNode head) {  
        // write your code here
       if(head == null || head.next == null){
           return;
       }
       
       ListNode mid = findMid(head);
       ListNode right = reverse(mid.next);
       mid.next = null;
       merge(head,right);
    }
}
