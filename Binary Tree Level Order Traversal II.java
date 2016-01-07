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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        helper(res, map, 0, root);
        
        for(int key = map.size() - 1; key >= 0; key--){
            res.add(map.get(key));
        }
        
        return res;
        
    }
    private void helper(ArrayList<ArrayList<Integer>> res, 
                        HashMap<Integer, ArrayList<Integer>> map, 
                        int lvl, 
                        TreeNode root){
        if(root == null){
            return;
        }
        
        if(!map.containsKey(lvl)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(lvl, list);
        }else{
            ArrayList<Integer> tmp = map.get(lvl);
            tmp.add(root.val);
            map.put(lvl, tmp);
        }
        
        helper(res, map, lvl + 1, root.left);
        helper(res, map, lvl + 1, root.right);
    }
}