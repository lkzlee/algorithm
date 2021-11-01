package com.lkzlee.acmcoder2021;



/***
 * @author: lkzlee
 * @date: 2021-10-22 15:37
 * @desc:二叉树
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明同学这段时间在学习数据结构中的二叉树。
 *
 * 一天，他遇到一个这样的问题：
 * 有一棵满二叉树，从根结点开始每一个结点都拥有一个编号，
 * 根结点的编号是1，其左子结点编号为2，右子结点编号为3，以此类推，
 * 从上至下、从左至右逐个按顺序为结点编号。
 * 现在为每个结点再增加一个正整数权重值，然后输入一个查询结点的编号，
 * 计算以该结点作为根结点的左子树所有结点和右子树所有结点的权重和。
 * 如果左子树的权重和大于右子树的权重和，输出“L”，如果右子树的权重和大于左子树的权重和，输出“R”，
 * 如果左、右子树的权重和相等，则输出“E”。
 * 如果待查询结点是叶子结点也输出“E"。 请编写一个程序实现上述功能。
 *
 * 输入描述
 * 第1行输入二叉树的总结点个数N，N<=1000。 第2行输入二叉树上N个结点每一个结点的权重值，两个权重值之间用英文空格隔开，按照从上至下，从左至右的顺序依次给出每个结点的权重值。
 *
 * 第3行输入待查询结点的编号（输入的编号<=N）。
 *
 * 输出描述
 * 按照题目要求输出指定的字符。以输入的待查询结点为根结点，如果左子树的权重和大于右子树的权重和，输出“L”，如果右子树的权重和大于左子树的权重和，输出“R”，如果左、右子树的权重和相等，则输出“E”。如果待查询结点是叶子结点也输出“E"。
 *
 *
 * 样例输入
 * 7
 * 1 2 3 3 2 5 1
 * 3
 * 样例输出
 * L
 */
import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int[] tree = new int[n];
            for (int i = 0; i < n; i++) {
                tree[i] = s.nextInt();
            }
            int t = s.nextInt();
            int l = 2 * (t - 1) + 1;
            int left = calcTreeNode(tree, l);
            int r = 2 * (t - 1)+2;
            int right = calcTreeNode(tree, r);
            if(left>right){
                System.out.println("L");
            }
            else if(left<right){
                System.out.println("R");
            }
            else{
                System.out.println("E");
            }


        }

    }

    public static int calcTreeNode(int[] tree, int t) {
        if (t >=tree.length || t < 0) return 0;
        int l = 2 * t + 1;
        int r = 2 * t + 2;
        return tree[t] + calcTreeNode(tree, l) + calcTreeNode(tree, r);
    }
}
