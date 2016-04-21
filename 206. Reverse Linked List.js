/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if(head === null){
        return head;
    }
    var dummy = new ListNode(-1);
    dummy.next = head;
    var cur = head.next;
    
    while(cur !== null){
        var next = cur.next;
        cur.next = dummy.next;
        dummy.next = cur;
        cur = next;
    }
    head.next = null;
    
    return dummy.next;
};