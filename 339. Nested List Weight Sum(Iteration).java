/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public class lvl_list{
        public NestedInteger list;
        public int level;
        public lvl_list(NestedInteger list, int lvl){
            this.list = list;
            level = lvl;
        }
    }
    
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        Stack<lvl_list> stack = new Stack<>();
        stack.push(new lvl_list(nestedList.get(0), 1));
        int index = 1, sum = 0;
        
        while(!stack.isEmpty()){
            lvl_list curr = stack.pop();
            if(curr.list.isInteger()){
                sum += curr.list.getInteger() * curr.level;
            }else{
                List<NestedInteger> tmp = curr.list.getList();
                for(NestedInteger n : tmp){
                    lvl_list new_item = new lvl_list(n, curr.level + 1);
                    stack.push(new_item);
                }
            }
            if(index < nestedList.size()){
                stack.push(new lvl_list(nestedList.get(index), curr.level));
            }
            index++;
        }
        
        return sum;
        
    }
}