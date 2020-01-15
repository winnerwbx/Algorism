package BinarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 */
public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 3, 1};
        boolean result = s.search(nums, 3);
        System.out.println(result);
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int point = findRotationPoint(nums);
            if (target > nums[nums.length - 1]) {
                return binarySearch(nums, 0, point - 1, target);
            } else {
                return binarySearch(nums, point, nums.length - 1, target);
            }
        }

        public boolean binarySearch(int[] nums, int left, int right, int target) {
            if (left > right) {
                return false;
            }
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left] == target;
        }

        /**
         * 先找到旋转点（数组中最小的且最靠左边的数）
         */
        public int findRotationPoint(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    // 收缩右边界
                    if (nums[right - 1] <= nums[right]){
                        right--;
                    }else {
                        left = right;
                    }

                    // 中位数跟末尾相等，再看左边界，如果左边界不等于末尾，则往左边查找，否则退化成线性查找
//                    if (nums[left] != nums[right]) {
//                        right = mid;
//                    } else {    // 从左往右查找首个不等于右边界的值
//                        int index = left;
//                        while (index < right) {
//                            if (nums[index] != nums[right]) {
//                                left = index;
//                                break;
//                            }
//                            index++;
//                        }
//                        if (left != index) { // 代表所有元素都相同
//                            return left;
//                        }
//                    }
                }
            }
            return left;
        }
    }
}
