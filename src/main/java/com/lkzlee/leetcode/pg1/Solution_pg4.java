package com.lkzlee.leetcode.pg1;

import java.util.HashMap;
import java.util.Map;

/***
 * 小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：
 *
 * 小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；
 * 小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
 * 现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。小扣可以搭乘任意编号的公交车且搭乘公交次数不限。
 *
 * 假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
 *
 * 注意：小扣可在移动过程中到达编号大于 target 的站点。
 *
 * 示例 1：
 *
 * 输入：target = 31, inc = 5, dec = 3, jump = [6], cost = [10]
 *
 * 输出：33
 *
 * 解释：
 * 小扣步行至 1 号站点，花费时间为 5；
 * 小扣从 1 号站台搭乘 0 号公交至 6 * 1 = 6 站台，花费时间为 10；
 * 小扣从 6 号站台步行至 5 号站台，花费时间为 3；
 * 小扣从 5 号站台搭乘 0 号公交至 6 * 5 = 30 站台，花费时间为 10；
 * 小扣从 30 号站台步行至 31 号站台，花费时间为 5；
 * 最终小扣花费总时间为 33。
 *
 * 示例 2：
 *
 * 输入：target = 612, inc = 4, dec = 5, jump = [3,6,8,11,5,10,4], cost = [4,7,6,3,7,6,4]
 *
 * 输出：26
 *
 * 解释：
 * 小扣步行至 1 号站点，花费时间为 4；
 * 小扣从 1 号站台搭乘 0 号公交至 3 * 1 = 3 站台，花费时间为 4；
 * 小扣从 3 号站台搭乘 3 号公交至 11 * 3 = 33 站台，花费时间为 3；
 * 小扣从 33 号站台步行至 34 站台，花费时间为 4；
 * 小扣从 34 号站台搭乘 0 号公交至 3 * 34 = 102 站台，花费时间为 4；
 * 小扣从 102 号站台搭乘 1 号公交至 6 * 102 = 612 站台，花费时间为 7；
 * 最终小扣花费总时间为 26。
 *
 * 提示：
 *
 * 1 <= target <= 10^9
 * 1 <= jump.length, cost.length <= 10
 * 2 <= jump[i] <= 10^6
 * 1 <= inc, dec, cost[i] <= 10^6
 */
public class Solution_pg4 {
    Map<Integer, Long> map = new HashMap<>();
    private static final int mod = (int) 1e7 + 9;

    //这个题好像还是没做对
    public long solve(int target, int inc, int dec, int[] jump, int[] cost) {
        if (target == 0) return 0;
        if (map.containsKey(target)) return map.get(target);
        long s = target * inc;
        for (int i = 0; i < jump.length; i++) {
            s = Math.min(s, solve(target / jump[i], inc, dec, jump, cost) + cost[i] + (long) (target % jump[i]) * inc);
            if (target > 1 && target % jump[i] != 0) {
                s = Math.min(s, solve(target / jump[i] + 1, inc, dec, jump, cost) + cost[i] + (long) (jump[i] - target % jump[i]) * dec);
            }
        }
        map.put(target, s);
        return s;
    }

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        /***
         * 到达位置target可以分为先到位置【target/jump[i]】(下取整的意思)，再经过一个jump[i]，
         * 然后一步一步增加走到target，也可以先走到【target/jump[i]】+ 1位置，再经过jump[i]，
         * 然后再一步一步减少到target，储存中间结果进行记忆化搜索
         */
        if (target == 0) return 0;
        return (int) (solve(target, inc, dec, jump, cost) % mod);
    }

    public static void main(String[] args) {
//        int target = 612, inc = 4, dec = 5;
//        int[] jump = new int[]{3, 6, 8, 11, 5, 10, 4}, cost = new int[]{4, 7, 6, 3, 7, 6, 4};

        int target = 31, inc = 5, dec = 3;
        int[] jump = new int[]{6}, cost = new int[]{10};
        int rs = new Solution_pg4().busRapidTransit(target, inc, dec, jump, cost);
        System.out.println(rs);
    }
}
