package recursion;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * https://leetcode.com/problems/permutations
 */
public class Permutations {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> integers : s.permute(nums)) {
            System.out.println(integers);
        }
    }

    /**
     * 思路：回溯法，传统思维，通过交换元素，避免重复
     */
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> input = new ArrayList<>();
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            backtrack(input, list, 0, nums.length);
            return input;
        }

        public void backtrack(List<List<Integer>> input, List<Integer> list, int index, int last) {
            if (index == last) {
                input.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < last; i++) {
                swap(list, i, index);
                backtrack(input, list, index + 1, last);
                // backtrack
                swap(list, i, index);
            }
        }

        public void swap(List<Integer> list, int indexA, int indexB) {
            int tmp = list.get(indexA);
            list.set(indexA, list.get(indexB));
            list.set(indexB, tmp);
        }
    }

    /**
     * 思路：回溯法，通过used标志进行排列，每一位看一下当前选择了的和未选择的，避免重复
     */
    static class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> input = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(input, new ArrayList<>(), nums, used);
            return input;
        }

        private void backtrack(List<List<Integer>> input, List<Integer> list, int[] nums, boolean[] used) {
            if (list.size() == nums.length) {
                input.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                backtrack(input, list, nums, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }


    }
}
