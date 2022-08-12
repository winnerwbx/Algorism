package Array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] inputs = new int[]{1, 0, 1};
        new MoveZeroes_283().new Solution().moveZeroes(inputs);
        for (int input : inputs) {
            System.out.println(input);
        }
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return;
            }
            int l = 0;
            for (int r = 0; r < length; r++) {
                if (nums[l] != 0) {
                    l++;
                    continue;
                }
                if (nums[r] != 0) {
                    nums[l] = nums[r];
                    nums[r] = 0;
                    l++;
                }
            }
        }
    }
}
