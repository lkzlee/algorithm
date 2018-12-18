package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/12/17 14:38
 * @Desc:
 */
public class LCS
{
	public int lengthOfLCS(int[] nums1, int[] nums2)
	{
		if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0)
			return 0;
		int n1 = nums1.length;
		int n2 = nums2.length;
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++)
		{
			for (int j = 1; j <= n2; j++)
			{
				if (nums1[i - 1] == nums2[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[n1][n2];
	}

	public static void main(String[] args)
	{
		int[] nums1 = new int[] { 1, 3, 5, 7, 9, 11 };
		int[] nums2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 12, 18, 19 };
		int rs = new LCS().lengthOfLCS(nums1, nums2);
		System.out.println(rs);
	}
}
