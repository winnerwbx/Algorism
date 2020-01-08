package BinarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[]{1, 3};
        int result = s.search(nums, 3);
        System.out.println(result);
    }

    static class Solution2 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int minimum = findRotationIndex(nums);
            if (target > nums[nums.length - 1]) {
                return binarySearchInSortedArray(nums, 0, minimum - 1, target);
            } else {
                return binarySearchInSortedArray(nums, minimum, nums.length - 1, target);
            }
        }

        public int binarySearchInSortedArray(int[] nums, int left, int right, int target) {
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        public int findRotationIndex(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return helper(nums, 0, nums.length - 1, target);
        }

        public int helper(int[] nums, int left, int right, int target) {
            if (left > right) {
                return -1;
            }
            if (left == right) {
                return nums[left] == target ? left : -1;
            }
            // 左中位数
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (target == midVal) {
                return mid;
            }
            if (target > midVal) {
                if (midVal > nums[right]) {
                    return helper(nums, mid + 1, right, target);
                } else {
                    if (target > nums[right]) {
                        return helper(nums, left, mid - 1, target);
                    } else {
                        return helper(nums, mid + 1, right, target);
                    }
                }
            } else {// target < midVal
                if (midVal < nums[right]) {
                    return helper(nums, left, mid - 1, target);
                } else {
                    if (target > nums[right]) {
                        return helper(nums, left, mid - 1, target);
                    } else {
                        return helper(nums, mid + 1, right, target);
                    }
                }
            }
        }
    }
}
