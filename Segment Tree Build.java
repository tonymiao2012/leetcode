/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end){
            return null;
        }
        if(start == end){
            return new SegmentTreeNode(start, start);
        }
        
        SegmentTreeNode cur = new SegmentTreeNode(start, end);
        
        SegmentTreeNode left = build(start, (start + end) / 2);
        SegmentTreeNode right = build((start + end) / 2 + 1, end);
        
        cur.left = left;
        cur.right = right;
        
        return cur;
    }
}