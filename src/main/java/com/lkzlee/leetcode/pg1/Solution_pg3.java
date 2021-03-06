package com.lkzlee.leetcode.pg1;


/***
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 */
public class Solution_pg3 {
    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.length() < 3) return 0;
        int rs = Integer.MAX_VALUE;
        int[][] dp = new int[leaves.length()][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = (int) 1e5;
            }
        }
        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        for (int i = 1; i < leaves.length(); i++) {
            if (leaves.charAt(i) == 'r') {
                dp[i][0] = dp[i - 1][0]; //调整最左变r最小次数
                dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0] + 1); // 调整y的最小次数
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1]); //调整右边r的最小次数
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]);
                dp[i][2] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
            }
        }
        return dp[leaves.length() - 1][2];
    }


    public static void main(String[] args) {
        String leaves = "ryryryryryryryr";
        int rs = new Solution_pg3().minimumOperations(leaves);
        System.out.println(rs);
    }
}
