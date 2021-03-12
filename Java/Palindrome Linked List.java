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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head == null){
            return true;
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ListNode index = head;
        while(index != null){
            nums.add(index.val);
            index = index.next;
        }
        
        ListNode newHead = reverseList(head);
        index = newHead;
        int i = 0;
        
        while(index != null && i < nums.size()){
            if(index.val != nums.get(i)){
                return false;
            }
            i++;
            index = index.next;
        }
        if(i < nums.size()){
            return false;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;
    }
}