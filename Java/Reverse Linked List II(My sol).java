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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    private class HeadAndTail{
        ListNode head;
        ListNode tail;
        public HeadAndTail(ListNode head, ListNode tail){
            this.head = head;
            this.tail = tail;
        }
    } 
    private HeadAndTail reverse(ListNode head){
        ListNode newHead = null;
        ListNode newTail = head;
        
        while(head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        
        HeadAndTail res = new HeadAndTail(newHead, newTail);
        return res;
    }
     
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre,post,cur = dummy;
        
        //Find pre
        int index = 0;
        while(index < m - 1){
            cur = cur.next;
            index++;
        }
        pre = cur;
        //Find post
        cur = cur.next;
        index = 0;
        while(index < n - m){
            cur = cur.next;
            index++;
        }
        post = cur.next;
        cur.next = null;
        
        //reverse list
        HeadAndTail curList = reverse(pre.next);
        pre.next = curList.head;
        curList.tail.next = post;
        
        return dummy.next;
    }
}