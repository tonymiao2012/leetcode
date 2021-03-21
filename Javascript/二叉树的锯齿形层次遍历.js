/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
 var zigzagLevelOrder = function(root) {
    let res = []
    helper(res, 1, root)

    return res
};

const helper = function(arr, level, root) {
    if(!root) {
        return
    }

    if(!arr.length || arr.length < level) {
        let newArr = []
        arr.push(newArr)
    }

    if(level % 2 === 1) {
        arr[level - 1].push(root.val)
        helper(arr, level + 1, root.left)
        helper(arr, level + 1, root.right)
    } else {
        arr[level - 1].unshift(root.val)
        helper(arr, level + 1, root.left)
        helper(arr, level + 1, root.right)
    }
}