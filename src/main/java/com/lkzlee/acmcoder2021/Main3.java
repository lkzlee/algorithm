package com.lkzlee.acmcoder2021;


/***
 * @author: lkzlee
 * @date: 2021-10-22 14:48
 * @desc:
 * 木箱子
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 现在有很多木箱子，每一个箱子都是标准的长方体并且都是空心的。
 * 如果一个木箱子的长、宽和高都大于（不能等于）另一个木箱子，则小的箱子可以套到大的箱子里面。（
 * 注意：此处不考虑材质本身的厚度，且每一个木箱子在嵌套的时候长、宽、高都不允许旋转）
 *
 * 现在告诉你一些长方体木箱子的长、宽和高，请问这些木箱子最多可以嵌套多少层？
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 第1行输入一个正整数N，表示长方体木箱子的总数量。(N<=1000)
 *
 * 接下来N行每行包含三个正整数，两两之间用空格隔开，分别表示每一个长方体木箱子的长、宽和高。（长、宽、高均小于等于10000。）
 *
 * 输出描述
 * 输出一个正整数，表示木箱子最多可以嵌套的层数。
 *
 *
 * 样例输入
 * 4
 * 1 2 3
 * 3 6 3
 * 2 3 4
 * 3 4 5
 * 样例输出
 * 3
 */

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int[] x = new int[n + 1];
            int[] y = new int[n + 1];
            int[] h = new int[n + 1];

            for (int i = 0; i < n; i++) {
                x[i] = s.nextInt();
                y[i] = s.nextInt();
                h[i] = s.nextInt();

            }
            int maxX = 0;
            int maxY = 0;
            int maxH = 0;

            for (int i = 0; i <= n; i++) {
                if (x[i] > maxX) maxX = x[i];
                if (y[i] > maxY) maxY = y[i];
                if (h[i] > maxH) maxH = h[i];
            }
            //dp[i][j][h] 标识长 宽 高分别是 i，j，h的最大嵌套数
            //dp[i][j][h] =Math.max(dp[i][j][h],dp[i-x[i]][j-y[i]][h-h[i]])
            int[][][] dp = new int[maxX + 1][maxY + 1][maxH + 1];
            for (int t = 0; t < n; t++) {
                dp[x[t]][y[t]][h[t]] = 1;
            }
            for (int t = 0; t < n; t++) {
                for (int i = 1; i < dp.length; i++) {
                    for (int j = 1; j < dp[i].length; j++) {
                        for (int k = 1; k < dp[i][j].length; k++) {
                            if (i > x[t] && j > y[t] && k > h[t]) {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - x[t]][j - y[t]][k - h[t]] + 1);
                            }

                        }
                    }
                }
            }
            System.out.println(dp[maxX][maxY][maxH]);


        }
    }
}
