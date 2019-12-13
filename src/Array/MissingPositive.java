package Array;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class MissingPositive {
    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * Use extra array
         * O(N) & O(N), should use O(N) & O(1)
         */
        public int firstMissingPositive2(int[] nums) {
            int length = nums.length;
            boolean[] store = new boolean[length + 1];
            for (int num : nums) {
                if (num > 0 && num < length + 1) {
                    store[num] = true;
                }
            }
            for (int i = 1; i < store.length; i++) {
                if (!store[i]) {
                    return i;
                }
            }
            return store.length;
        }

        /**
         * O(N) time and O(1) space
         */
        public int firstMissingPositive(int[] nums) {
            // 交换数组元素，将数字放到对应的位置上
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 // index和所在元素不相等时交换
                        && nums[i] > 0 && nums[i] <= nums.length // 满足约束
                        && nums[i] != nums[nums[i] - 1]) { // 避免重复交换死循环
                    swap(nums, i, nums[i] - 1);
                }
            }
            // 遍历交换完毕的数组，找到不符合位置的元素
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        public void swap(int[] nums, int xIndex, int yIndex) {
            int tmp = nums[xIndex];
            nums[xIndex] = nums[yIndex];
            nums[yIndex] = tmp;
        }
    }
}
