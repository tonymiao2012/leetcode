public class solution{
	public int longestConsecutive(TreeNode root){
		if(root == null){
			return 0;
		}
		return helper(root, 1);
	}
	private int helper(TreeNode root, int num){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return num;
		}

		int left, right;
		if(root.val + 1 = root.left.val){
			left = helper(root.left, num + 1);
		}else{
			left = helper(root.left, num);
		}
		if(root.val + 1 == root.right.val){
			right = helper(root.right, num + 1;
		}else{
			right = helper(root.right, num);
		}

		return Math.max(left, right);
	}
}