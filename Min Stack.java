public class MinStack {
    Stack<Integer> num;
    Stack<Integer> min;
    
    public MinStack() {
        // do initialize if necessary
        num = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        num.push(number);
        if(min.isEmpty()){
            min.push(number);
        }else{
            int top = min.peek();
            min.push(Math.min(top, number));
        }
    }

    public int pop() {
        // write your code here
        if(num.isEmpty()){
            return -1;
        }else{
            min.pop();
            return num.pop();
        }
    }

    public int min() {
        // write your code here
        if(min.isEmpty()){
            return Integer.MIN_VALUE;
        }else{
            return min.peek();
        }
    }
}
