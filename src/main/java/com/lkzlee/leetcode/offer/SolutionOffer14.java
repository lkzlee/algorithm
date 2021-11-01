package com.lkzlee.leetcode.offer;

import java.util.Arrays;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/23 17:21
 * @desc: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionOffer14 {
    /***
     * n长的绳子相当于一个n的正整数
     * dp[i]表示i长的绳子截断m次后的最大乘积,m>1
     * 状态转移：
     * 遍历j=1..i-1,则绳子可以分为j和i-j两部分,假设i-j也可以被分
     * dp[i] = max(j*(i-j),j*dp[i-j])
     * 取其中最大的dp[i]
     */
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        SolutionOffer14 res = new SolutionOffer14();
        System.out.println(res.cuttingRope(10));
    }
}
