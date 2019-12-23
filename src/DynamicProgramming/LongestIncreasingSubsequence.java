package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    /**
     * <a herf="https://leetcode.com/problems/longest-increasing-subsequence/">LeetCode #300</a>
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     * <p>
     * Example:
     * <p>
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Note:
     * <p>
     * There may be more than one LIS combination, it is only necessary for you to return the length.
     * Your algorithm should run in O(n2) complexity.
     * Follow up: Could you improve it to O(n log n) time complexity?
     */
    class Solution {
        /**
         * 动态规划，O(N^2)
         */
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return length;
            }
            // dp[i]存储的是以 nums[i] 结尾的“最长上升子序列”的长度
            int[] dp = new int[length];
            int max = 1;
            dp[0] = 1; // 初始化为1，如果为单调递减序列，则各个位置的LIS都为1
            for (int i = 1; i < length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        /**
         * 动态规划+二分查找 O(NlogN)
         */
        public int lengthOfLIS2(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return length;
            }
            // tail[i] 表示长度为 i + 1 （因为 i 表示索引，i + 1 表示长度）的所有“上升子序列”里结尾最小的元素
            // tail的长度就是最长上升子序列的长度
            int[] tails = new int[length];
            tails[0] = nums[0]; // 首先初始化第一个数
            int end = 0; // tails里最后一个数的index
            for (int i = 1; i < length; i++) {
                // 假如nums[i]比tails最后一个数都大，直接加入到tails尾部，更新end指针
                if (nums[i] > tails[end]) {
                    end++;
                    tails[end] = nums[i];
                } else {
                    int left = 0;
                    int right = end;
                    // 从tails里找到>nums[i]的最小的一个数，并替换之
                    // 此处使用二分查找
                    while (left < right) {
                        // 求和/2，获取左中位数，不怕溢出
                        int mid = (left + right) >>> 1;
                        // 先判断不符合条件
                        if (tails[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            // 可能包括mid，所以right=mid
                            right = mid;
                        }
                    }
                    tails[left] = nums[i];
                }
            }
            // 返回tails的数组长度
            return end + 1;
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            // dp[i]代表以index=i结尾的数组中最长上升子序列的长度
            int[] dp = new int[nums.length];
            int result = 1;
            // 1. 初始化dp，都置为1
            Arrays.fill(dp, 1);
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }

        public int lis(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            List<Integer> result = new ArrayList<>();
            result.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > result.get(result.size() - 1)) {
                    result.add(nums[i]);
                } else {
                    // 二分查找该替换的元素
                    int left = 0;
                    int right = result.size() - 1;
                    while (left < right) {
                        int mid = (left + right) >>> 1;
                        if (result.get(mid) < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    result.set(left, nums[i]);
                }
            }
            return result.size();
        }
    }
}
