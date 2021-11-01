package com.lkzlee.acmcoder2021;
import java.util.Scanner;

/***
 * @author: lkzlee
 * @date: 2021-10-22 16:04
 * @desc:
 * 挖掘宝石
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明设计了一个挖掘宝石的小游戏。
 *
 * 在游戏中有红宝石、蓝宝石、绿宝石等多种不同类型的宝石，当然也有昂贵的钻石。
 * 现在给出一个地图，在地图上有N种不同的宝石。
 * 每一种宝石都有一颗或者多颗，同一种宝石每一颗的价值都是相同的。
 * 此外，每一种宝石都有一个挖掘时间。
 * 在给定的时间内，哪一个玩家挖掘的宝石的总价值最大就是游戏的赢家。
 * 现在给出N类不同宝石的数量以及每一类宝石中每一颗的价值和挖掘时间，并且给出一个总的游戏时间T。
 * 在不考虑竞争对手的情况下，请问可以得到的最大价值是多少？
 * 输入描述
 * 单组输入。
 * 第1行输入一个正整数N和一个正整数T，分别表示宝石类型的数量和总游戏时间（分钟），两者之间用空格隔开。N<=100，T<=1000。
 * 从第2行到第N+1行每一行三个正整数X[i]，Y[i]和Z[i]，分别表示第i类宝石的数量、第i类宝石中一颗宝石的价值和挖掘时间（分钟）。X[i]、Y[i]和Z[i]均不超过100。
 *
 * 输出描述
 * 输出可以得到的最大价值。
 *
 *
 * 样例输入
 * 3 10
 * 2 5 5
 * 3 4 3
 * 2 8 6
 * 样例输出
 * 12
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int cost = s.nextInt();
            int[] x = new int[n + 1];
            int[] y = new int[n + 1];
            int[] z = new int[n + 1];
            int[][] dp = new int[n + 1][cost + 1];
            //X[i]，Y[i]和Z[i]
            //dp[i][j] b标识宝石数量为i 挖掘时间为j 的宝石最大价值
            //dp[i][j]=Math.max(dp[i-x[i]][j-z[i]]+x[i]*y[i],dp[i-x[i]-1])
            //dp[i][j] =Math.max(dp[i-k][j-k*z[i]]+k*y[i],dp[i][j])
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j <= cost; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i <= n; i++) {
                x[i] = s.nextInt();
                y[i] = s.nextInt();
                z[i] = s.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= cost; j++) {
                    for (int k = 1; k <= x[i]; k++) {
                        if (i >= k && j >= k * z[i])
                            dp[i][j] = Math.max(dp[i][j], dp[i - k][j - k * z[i]] + k * y[i]);
                    }
                }
            }
            System.out.println(dp[n][cost]);

        }

    }
}
