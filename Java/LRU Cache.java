public class Solution {

    private class Node{
        Node prev;
        Node next;
        int key;
        int value;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(!hs.containsKey(key)){
            return -1;
        }
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        move_to_tail(current);
        
        return hs.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(get(key) != -1){
            hs.get(key).value = value;
            return;
        }
        //Remove least recently used item
        if(hs.size() == capacity){
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }
    
    private void move_to_tail(Node current){
        tail.prev.next = current;
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
    }
}