package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * //Given an array of integers nums and an integer k, return the total number of
 * //continuous subarrays whose sum equals to k.
 * //
 * //
 * // Example 1:
 * // Input: nums = [1,1,1], k = 2
 * //Output: 2
 * // Example 2:
 * // Input: nums = [1,2,3], k = 3
 * //Output: 2
 * //
 * //
 * // Constraints:
 * //
 * //
 * // 1 <= nums.length <= 2 * 10⁴
 * // -1000 <= nums[i] <= 1000
 * // -10⁷ <= k <= 10⁷
 * //
 * // Related Topics 数组 哈希表 前缀和 👍 1051 👎 0
 */
public class SubarraySumEqualsK560 {
    class Solution {
        /**
         * 2 pointers solution: O(N) + O(1)
         */
        public int subarraySum2Pointers(int[] nums, int k) {
            // 0. edge condition
            if (nums.length <= 0) {
                return 0;
            }
            // 1. 构建前缀和
            int[] sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            // 2. 双指针计数
            // IMPORTANT: 负数需要考虑
            int left = 0, right = 1;
            int result = 0;
            while (left < sums.length) {
                if (right == sums.length) {
                    left++;
                    right = left + 1;
                    continue;
                }
                if (sums[right] - sums[left] == k) {
                    result++;
                }
                right++;
            }
            return result;
        }

        /**
         * HashMap solution: O(N) + O(1)
         */
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            // 0. edge condition
            if (len <= 0) {
                return 0;
            }
            int count = 0;
            // 1. 前缀和+Map查询
            Map<Integer, Integer> map = new HashMap<>();
            // 1. 构建前缀和
            map.put(0, 1);
            int pre = 0;
            for (int i = 0; i < len; i++) {
                pre += nums[i];
                map.compute(pre, (key, v) -> {
                    if (v == null) {
                        return 1;
                    } else {
                        return v + 1;
                    }
                });
                count += map.getOrDefault(pre - k, 0);
            }
            return count;
        }

        /**
         * Normal solution O(n2)
         */
        public int subarraySumON2(int[] nums, int k) {
            // 1. build a sum array
            int length = nums.length;
            int[] sums = new int[length + 1];
            sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            // 2. find out count of subarray sum equals k
            int count = 0;
            for (int i = 0; i < sums.length; i++) {
                for (int j = i + 1; j < sums.length; j++) {
                    if (sums[j] - sums[i] == k) {
                        count++;
                    }
                }
            }
            return count;
        }

    }
}
