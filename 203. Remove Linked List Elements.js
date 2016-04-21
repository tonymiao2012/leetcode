/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    while(head !== null && head.val === val){
        head = head.next;
    }
    if(head === null){
        return head;
    }
    var pre = head;
    while(pre !== null && pre.next !== null){
        var cur = pre.next;
        if(cur.val !== val){
            pre = cur;
            continue;
        }
        pre.next = cur.next;
    }
    
    return head;
};