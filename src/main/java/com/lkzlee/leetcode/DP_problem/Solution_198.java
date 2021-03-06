package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/10/16 10:57
 * @Desc:
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的* 防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Solution_198
{
	public int rob(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return 0;
		/***
		 * 	该题的思路是定义一个数组dp[j] 表示从0...j间的最大偷窃金额，
		 *
		 */
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			if (i == 0 || i == 1)
			{
				/***
				 * 其次，这块的边界条件也没处理好
				 */
				if (i == 0)
				{
					dp[i] = nums[i];
				}
				else if (i == 1)
				{
					dp[i] = Math.max(nums[i], nums[i - 1]);
				}
				continue;
			}
			int maxSum = dp[i - 1]; //一开始这个没处理好
			for (int j = 0; j < i - 1; j++)
			{
				if (maxSum < dp[j] + nums[i])
				{
					maxSum = dp[j] + nums[i];
				}
			}
			dp[i] = maxSum;
		}
		return dp[nums.length - 1];

	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 3, 1 };
		int rs = new Solution_198().rob(nums);
		System.out.println(rs);
	}
}
