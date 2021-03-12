class Stack {
    public Queue<Integer> q1 = new ArrayDeque<>();
    public Queue<Integer> q2 = new ArrayDeque<>();
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        q1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if(q1.size() == 0){
            return;
        }
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        q1.poll();
        //Add back.
        while(q2.size() > 0){
            q1.offer(q2.poll());
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if(q1.size() == 0){
            return -1;
        }
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        q2.offer(res);
        //Add back.
        while(q2.size() > 0){
            q1.offer(q2.poll());
        }
        
        return res;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }    
}