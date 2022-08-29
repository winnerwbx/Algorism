package BinarySearch;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 * Related Topics
 * 数组
 * 二分查找
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    static class Solution {
        // test
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] case1 = new int[]{5, 7, 7, 8, 8, 10};
            int[] target1 = new int[]{3, 4};
            int[] result1 = solution.searchRange(case1, 8);
            testOk(target1, result1);
            int[] target2 = new int[]{-1, -1};
            int[] result2 = solution.searchRange(case1, 6);
            testOk(target2, result2);
            int[] case3 = new int[0];
            int[] result3 = solution.searchRange(case3, 0);
            int[] target3 = new int[]{-1, -1};
            testOk(target3, result3);
        }

        private static void testOk(int[] target1, int[] result1) {
            for (int i = 0; i < target1.length; i++) {
                System.out.println(target1[i] == result1[i]);
            }
        }

        public int[] searchRange(int[] nums, int target) {
            int fp = -1, lp = -1;
            int[] result = new int[]{-1, -1};
            if (nums.length == 0) {
                return result;
            }
            int left = 0, right = nums.length - 1;
            // find first position
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                }
            }
            if (left >= nums.length || nums[left] != target) {
                fp = -1;
            } else {
                fp = left;
            }
            // re init
            left = 0;
            right = nums.length - 1;
            // find right position
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }
            if (right < 0 || nums[right] != target) {
                lp = -1;
            } else {
                lp = right;
            }
            return new int[]{fp, lp};
        }
    }
}
