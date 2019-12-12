package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{-4, -4, -3, -2, -1, 0, 2});
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            // 1. 排序，用于去重
            Arrays.sort(nums);
            // 2. 从左往右，确定第一个元素，剩下的元素使用首位指针的方法
            for (int i = 0; i < nums.length - 2; i++) {
                // 第一个元素比0大，则后面所有元素都比0大，无解;最后一个元素<0，也无解
                if (nums[i] > 0 || nums[nums.length - 1] < 0) {
                    break;
                }
                // 如果nums[i]和前一个nums[i-1]相等，则跳过这个元素，因为之前已经计算过了
                if (i > 0 && (nums[i] == nums[i - 1])) {
                    continue;
                }
                int sum = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                // 左右双指针往中间查找
                while (left < right) {
                    // 超过边界条件
                    if (nums[left] > 0 || nums[right] < 0) {
                        break;
                    }
                    int curSum = nums[left] + nums[right];
                    if (curSum < sum) {
                        left++;
                    } else if (curSum > sum) {
                        right--;
                    } else {
                        // 左边界跟前一个左边界重复，则跳过，否则会有重复的元素
                        if (left - 1 == i || nums[left] != nums[left - 1]) {
                            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        }
                        left++;
                        right--;
                    }
                }
            }
            return result;
        }
    }
}
