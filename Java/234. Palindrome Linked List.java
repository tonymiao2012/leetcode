/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
 //1. 找到中点，断开链表。
 //2. 将后半段反转，返回头值。
 //3. 看两端是否相等。
/**
 * @param {ListNode} head
 * @return {boolean}
 */

var reverse = function(head){
        if(head === null || head.next === null){
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

var isPalindrome = function(head) {
    if(head === null || head.next === null){
        return true;
    }
    var fast = head, slow = head, curHead = head;
    while(fast.next !== null && fast.next.next !== null){
        fast = fast.next.next;
        slow = slow.next;
    }
    while(fast.next !== null){
        fast = fast.next;
    }
    slow = slow.next;
    var newHead = reverse(slow);
    while(newHead !== null){
        if(newHead.val !== curHead.val){
            return false;
        }
        newHead = newHead.next;
        curHead = curHead.next;
    }
    
    return true;
};