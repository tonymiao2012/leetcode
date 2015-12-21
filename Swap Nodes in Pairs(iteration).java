/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    //Time complexity: O(1), space complexity: O(1)
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, prev = dummy;
        while(cur != null && cur.next != null){
            ListNode after = cur.next;
            ListNode nextCur = after.next;
            after.next = cur;
            cur.next = nextCur;
            prev.next = after;
            prev = cur;
            cur = nextCur;
        }
        
        return dummy.next;
    }
}