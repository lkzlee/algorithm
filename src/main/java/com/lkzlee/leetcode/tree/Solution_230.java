package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 9:35
 * @desc: 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_230 {
    private Integer val;
    private Integer cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTree(root, k);
        return val;
    }

    private void inOrderTree(TreeNode root, int k) {
        if (root == null) return;
        inOrderTree(root.left, k);
        cnt++;
        if (k == cnt) {
            val = root.val;
            return;
        }
        inOrderTree(root.right, k);

    }
}
