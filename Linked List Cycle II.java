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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
     /*
     * X: steps before cycle start Y: cycle length K: steps alread run in cycle
     * When fast meets slow pointer
     * fast pointer steps: 2t = X + nY + K;
     * slow pointer steps: t = X + mY + K;
     * -> X + K = (n - 2m)Y
     * So after meeting each other, run another X, the pointer will be back to start of cycle. 
     */
     
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null){
            fast = fast.next;
            slow = slow.next;
            if(fast != null){
                fast = fast.next;
            }
            if(slow == fast){
                break;
            }            
        }
        if(fast == null){
            return null;
        }
        
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}
