package Array;

/**
 * //Given an integer array nums and an integer val, remove all occurrences of val
 * //in nums in-place. The relative order of the elements may be changed.
 * //
 * // Since it is impossible to change the length of the array in some languages,
 * //you must instead have the result be placed in the first part of the array nums.
 * //More formally, if there are k elements after removing the duplicates, then the
 * //first k elements of nums should hold the final result. It does not matter what
 * //you leave beyond the first k elements.
 * //
 * // Return k after placing the final result in the first k slots of nums.
 * //
 * // Do not allocate extra space for another array. You must do this by modifying
 * //the input array in-place with O(1) extra memory.
 * //
 * // Custom Judge:
 * //
 * // The judge will test your solution with the following code:
 * //
 * //
 * //int[] nums = [...]; // Input array
 * //int val = ...; // Value to remove
 * //int[] expectedNums = [...]; // The expected answer with correct length.
 * //                            // It is sorted with no values equaling val.
 * //
 * //int k = removeElement(nums, val); // Calls your implementation
 * //
 * //assert k == expectedNums.length;
 * //sort(nums, 0, k); // Sort the first k elements of nums
 * //for (int i = 0; i < actualLength; i++) {
 * //    assert nums[i] == expectedNums[i];
 * //}
 * //
 * //
 * // If all assertions pass, then your solution will be accepted.
 */
public class RemoveElements27 {
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 2, 3};
        int val = 3;
        int[] expect = new int[]{2, 2};
        Solution s = new RemoveElements27().new Solution();
        int i = s.removeElement(input, val);
        assert i == 2;
        for (int i1 = 0; i1 < expect.length; i1++) {
            assert input[i1] == expect[i1];
        }
    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            if (n <= 0) {
                return 0;
            }
            int left = 0, right = 0;
            while (right < n) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            return left;
        }
    }

}
