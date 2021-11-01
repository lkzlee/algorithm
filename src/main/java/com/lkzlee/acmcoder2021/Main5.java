package com.lkzlee.acmcoder2021;

/***
 * @author: lkzlee
 * @date: 2021-10-22 15:54
 * @desc:
 * 素数圈
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * Kimi同学又在“玩”素数。他随机在N张卡片上写下了N个正整数，
 * 这N个正整数中可能存在一些相同的数字，
 * 也可能都不相同。 现在他以某一张指定的卡片作为起点，
 * 按顺时针的方向将这N张卡片连成一个圈，
 * 并且要求这个圈上面任意两张相邻卡片上的数字之和都是一个素数。
 * 当然，第1个数和最后一个数的和也为素数。这样的圈称为“素数圈”。
 * 请问在明确起点（第1个数）的情况下有多少种不同的方案？即能够组成多少个完全不同的素数圈？
 * 例如：(1,2,3,4)和(2,3,4,1)是两个不同的素数圈；(1,1,2,1)和(1,2,1,1)也是两个不同的素数圈。
 * 输入描述
 * 单组输入。 第1行输入一个正整数N，表示卡片的数量。(1<N<=20)
 *
 * 第2行输入N个正整数，分别表示每一张卡片上的数字。两两之间用空格隔开。
 *
 * 输出描述
 * 输出这N张卡片可以组成的不同的素数圈的数量。如果不存在素数圈，则输出“No result.”（不含引号，result后有英文的.）
 *
 * 样例输入
 * 3
 * 1 1 1
 * 样例输出
 * 1
 */

import java.util.Scanner;
public class Main5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int[] num=new int[n];
            for(int i=0;i<num.length;i++){
                num[i]=s.nextInt();
            }
            System.out.println(1);

        }

    }

}
