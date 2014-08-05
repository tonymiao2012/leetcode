package leetcode;

import java.util.ArrayList;

public class pathSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        helper(root, sum, result, temp);
        return result;
    }
    public void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        
        //ArrayList<Integer> temp = new ArrayList<Integer>();
        if(root == null){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null){
            //temp.add(root.val);
            if(sum == root.val){
                //save path to result.
                ArrayList<Integer> cur = new ArrayList<Integer>();
                for(int i:temp){
                    cur.add(i);
                }
                result.add(cur);
            }
        }
        helper(root.left, sum - root.val, result, temp);
        helper(root.right, sum - root.val, result, temp);
        temp.remove(temp.size() - 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
