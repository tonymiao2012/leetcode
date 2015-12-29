/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        helper(root, map, 0);
        for(int i : map.keySet()){
            ArrayList<Integer> tmp = map.get(i);
            res.add(tmp);
        }
        return res;
    }
    private void helper(TreeNode root, 
                        HashMap<Integer,ArrayList<Integer>> map,
                        int level){
        if(root == null){
            return;
        }
        if(!map.containsKey(level)){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            map.put(level, tmp);
        } 
        ArrayList<Integer> lvlList = map.get(level);
        
        if(level % 2 == 0){
            lvlList.add(root.val);
        }else{
            lvlList.add(0, root.val);
        }
        
        helper(root.left, map, level + 1);
        helper(root.right, map, level + 1);
    }
}