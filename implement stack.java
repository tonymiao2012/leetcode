class Stack {
    private ArrayList<Integer> stack = new ArrayList<>();;
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        this.stack.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        this.stack.remove(stack.size() - 1);
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return this.stack.get(stack.size() - 1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return this.stack.isEmpty();
    }    
}