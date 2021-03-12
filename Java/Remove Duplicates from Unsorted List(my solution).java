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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head, prev = null;
        while(cur != null){
            int curVal = cur.val;
            if(map.containsKey(curVal)){
                prev.next = cur.next;
            }else{
                map.put(curVal, cur);
                prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head;
    }  
}