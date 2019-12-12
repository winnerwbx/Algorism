package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 * 169. Majority Element
 * Easy
 * <p>
 * 2207
 * <p>
 * 187
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityNum {
    static class Solution {
        public int majorityElement(int[] nums) {
            int result = 0;
            int times = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.merge(nums[i], 1, Integer::sum);
                if (map.get(nums[i]) > times) {
                    result = nums[i];
                    times = map.get(nums[i]);
                }
                if (times > nums.length / 2 + 1) {
                    break;
                }
            }
            return result;
        }

        public int majorityElement2(int[] nums) {
            int res = nums[0];
            int total = 0;
            for (int num : nums) {
                if (total == 0) {
                    res = num;
                }
                if (res == num) {
                    total = total + 1;
                } else {
                    total = total - 1;
                }
            }
            return res;
        }
    }
}
