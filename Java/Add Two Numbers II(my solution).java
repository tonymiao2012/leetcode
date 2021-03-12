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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode newL1 = reverseList(l1);
        ListNode newL2 = reverseList(l2);
        
        ListNode newSum = addLists(newL1, newL2);
        return reverseList(newSum);
    }  
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head = prev;
        
        return head;
    }
    
    private ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        
        while(l1 != null && l2 != null){
            int cur = l1.val + l2.val + carry;
            carry = cur / 10;
            ListNode newTmp = new ListNode(cur % 10);
            prev.next = newTmp;
            
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 != null){
            mergeList(carry, prev, l2);
        }else if(l2 == null && l1 != null){
            mergeList(carry, prev, l1);
        }else{  
            //l1 == null && l2 == null, check carry.
            if(carry > 0){
                ListNode last = new ListNode(carry);
                prev.next = last;
            }
        }

        return dummy.next;
    }
    
    private void mergeList(int carry, ListNode prev, ListNode list){
        while(list != null){
            int val = carry + list.val;
            carry = val / 10;
            ListNode newNode = new ListNode(val % 10);
            
            prev.next = newNode;
            prev = prev.next;
            list = list.next;
        }
    }
}