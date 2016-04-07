public class LRUCache {
    private ArrayDeque<Integer> deque;
    private HashMap<Integer, Integer> map;
    private int capacity = 0;
    private int count = 0;
    
    public LRUCache(int capacity) {
        deque = new ArrayDeque<Integer>(capacity);
        map = new HashMap<Integer, Integer>();
        capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            //update frequency.
            deque.removeFirstOccurrence(key);
            deque.offer(key);
            int val = map.get(key);
            return val;
        }
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key)){
            if(count == capacity && !deque.isEmpty()){
                int tmpKey = deque.poll();
                map.remove(tmpKey);
            }
            deque.offer(key);
            map.put(key, value);
            count++;
        }else{
            deque.removeFirstOccurrence(key);
            deque.offer(key);
            map.put(key, value);
        }
    }
}