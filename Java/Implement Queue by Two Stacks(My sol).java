public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       this.stack1 = new Stack<Integer>();
       this.stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        if(stack2.isEmpty()){
            stack1.push(element);
        }else{
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(element);
        }
    }

    public int pop() {
        // write your code here
        if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
           
        }
        return stack2.peek();
        
    }
}