public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        if(stack.empty()){
            return;
        }
        Stack<Integer> tmp = new Stack<Integer>();
        
        while(!stack.empty()){
            int cur = stack.pop();
            while(!tmp.isEmpty() && tmp.peek() > cur){
                stack.push(tmp.pop());
            }
            tmp.push(cur);
        }
        Collections.reverse(tmp);
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
    }
}