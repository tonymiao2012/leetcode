package leetcode;


public class sumRootToLeaf {
	public static int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}
		// get all root-to-leaf numbers first. then sum them. DFS
		return sum(root, 0, 0);

	}

	public static int sum(TreeNode root, int temp, int result) {

		if (root == null) {
			return result;
		}
		temp = temp * 10 + root.val;
		// leaf node.
		if (root.left == null && root.right == null) {
			result += temp;
			return result;
		}
		result = sum(root.left, temp, result) + sum(root.right, temp, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(0);
		TreeNode right = new TreeNode(0);
		root.left = left;
		root.right = right;
		System.out.println(sumRootToLeaf.sumNumbers(root));
	}

}
