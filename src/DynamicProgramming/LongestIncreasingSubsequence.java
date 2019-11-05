package DynamicProgramming;

public class LongestIncreasingSubsequence {
    /**
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
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return length;
            }
            int[] results = new int[length];
            int max = 1;
            results[0] = 1; // 初始化为1，如果为单调递减序列，则各个位置的LIS都为1
            for (int i = 1; i < length; i++) {
                results[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        results[i] = Math.max(results[j] + 1, results[i]);
                    }
                }
                max = Math.max(max, results[i]);
            }
            return max;
        }
    }
}
