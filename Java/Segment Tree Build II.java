/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return null;
        }
        return helper(A, 0, A.length - 1);
    }
    
    private SegmentTreeNode helper(int[] A, int start, int end){
        if(start > end){
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        if(start != end){
            int mid = (start + end) / 2;
            root.left = helper(A, start, mid);
            root.right = helper(A, mid + 1, end);
            root.max = Math.max(root.left.max, root.right.max);
        }else{
            root.max = A[start];
        }
        return root;
    }
}