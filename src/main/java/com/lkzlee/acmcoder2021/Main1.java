package com.lkzlee.acmcoder2021;


/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 程序员小周同学这几天在看《三国演义》。今天他看到了“草船借箭”这一回，在钦佩诸葛亮巧借东风向曹操“借”箭的同时，
 * 小周想到这么一个问题：
 * 如果诸葛亮一共派出了N条放置草人的船来“借”箭。
 * “慷慨”的曹操向第1条草船上射了A支箭、第2条草船上射了B支箭，
 * 第3条草船上射的箭的数量等于前面两条船上箭的数量之和多一支，
 * 第4条草船上射的箭的数量等于前面三条船上的箭的数量之和多一支，......，以此类推，
 * 第N条草船上箭的数量等于前面N-1条船上箭的数量之和多一支。
 * 下面问题来了，请问这一次诸葛亮一共从曹操那里“借”了多少支箭呢？

 *
 * 输入描述
 * 单组输入。 输入三个正整数N、A和B，三个正整数都不超过1000，并且保证N>1，且两两之间用空格隔开。
 *
 * 输出描述
 * 输出诸葛亮“借”箭的总数量，结果对1e9+7取模。

 *
 * 样例输入
 * 4 1 2
 * 样例输出
 * 15
 */

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int m = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            long res = fnRet(m, a, b);
            int rs = (int) (res % (1e9 + 7));
            System.out.println(rs);
        }
    }

    private static long fnRet(int n, int a, int b) {
        if (n == 1) return (long) a;
        if (n == 2) return (long) b;
        long[] dp = new long[n + 1];
        dp[1] = (long) a;
        dp[2] = (long) b;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = res + dp[i];
        }
        return(long)(res% (1e9 + 7));
    }
}
