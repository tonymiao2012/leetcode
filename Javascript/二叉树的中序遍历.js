/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 * 递归方法
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
 var inorderTraversal = function(root) {
    if(!root) {
        return []
    }
    let res = []
    helper(res, root)

    return res
};

const helper = function(arr, root) {
    if(!root) {
        return
    }

    helper(arr, root.left)
    arr.push(root.val)
    helper(arr, root.right)
}