package com.lkzlee.acmcoder2021;


/***
 * @author: lkzlee
 * @date: 2021-10-22 14:46
 * @desc:
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * Kimi今天在玩一个数字变换游戏。游戏规则如下：
 * 首先给出N个数字0。
 * 然后开始从数字S开始报数，当报数为S时，将所有出现在S以及S的倍数位置的0变成1（位置编号从1开始），
 * 当所有S及S倍数位置的数字都变换之后即完成了一趟数字变换。
 * 接下来报数S+1，将所有出现在S+1以及S+1的倍数位置的数字进行一次变换。如
 * 果原来数字为0，则变成1；01，则变成0。
 * 接下来报数S+2，相应的也需要将所有出现在S+2以及S+2的倍数位置的数字进行一次变换。
 * 如果原来数字为0，则变成1；
 * 如果原来数字为1，则变成0。 ...... 当报数为数字T（T>S）时，将所有T以及T的倍数位置的数字都进行一次变换。
 * 如果原来数字为0，则变成1；如果原来数字为1，则变成0。
 * 请问在报数T结束，且所有对应位置的数字都变换后，所有的数字中一共有多少个1？
 *
 *
 * 输入描述
 * 单组输入。 输入三个正整数N、S和T。N<=1000，1<=S<T<=N 从S开始报数直到T结束，包含S和T。
 *
 * 输出描述
 * 输出变换之后，在所有的数字中最终包含的1的个数。
 *
 *
 * 样例输入
 * 10 1 10
 * 样例输出
 * 3
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            int[] num = new int[n + 1];
            Arrays.fill(num, 0);
            for (int i = s; i <= t; i++) {
                for (int j = i, k = 1; k * j <= n; k++) {
                    if (num[k * j] == 0) num[k * j] = 1;
                    else num[k * j] = 0;
                }
//                System.out.println(Arrays.toString(num));
            }
            int no = 0;
            for (int i = 1; i < num.length; i++) {
                if (num[i] == 1) no++;
            }
            System.out.println(no);

        }
    }
}
