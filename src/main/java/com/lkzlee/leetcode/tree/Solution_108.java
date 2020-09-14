package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/***
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) return null;
        int low = 0, high = nums.length - 1;
        return doCreateBst(nums, low, high);
    }

    private TreeNode doCreateBst(int[] nums, int i, int j) {
        if (i > j) return null;
        int mid = i + (j - i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doCreateBst(nums, i, mid - 1);
        root.right = doCreateBst(nums, mid + 1, j);
        return root;
    }
}
