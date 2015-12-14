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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable.length == 0){
            return hashTable;
        }
        
        int capacity = 2 * hashTable.length;
        ListNode[] newHashTable = new ListNode[capacity];
        //rehash
        for(int i = 0; i < hashTable.length; i++){
            ListNode cur = hashTable[i];
            while(cur != null){
                int key = (cur.val % capacity + capacity) % capacity;
                if(newHashTable[key] == null){
                    newHashTable[key] = new ListNode(cur.val);
                }else{
                    ListNode dummy = newHashTable[key];
                    while(dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(cur.val);
                }
                cur = cur.next;
            }
        }
        
        return newHashTable;
        
    }
}
