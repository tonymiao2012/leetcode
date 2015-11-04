public class Solution {
    public int calculate(String s) {
        if(s == null) return 0;
        
        int result = 0,sign = 1, num = 0;
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(sign);
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' ')    continue;
            
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else if(c == '+' || c == '-'){
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            }else if(c == '(')
                stack.push(sign);
            else
                stack.pop();
        }
        
        result += sign * num;
        
        return result;
        
    }
}