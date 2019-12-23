package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k > nums.length) {
                return new int[0];
            }
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            // put elements' index into deque
            for (int i = 0; i < nums.length; i++) {
                // queue is full, remove first
                if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                    deque.pollFirst();
                }
                // put into queue, all elements which are smaller than nums[i] should be polled from right
                while (deque.peekLast() != null && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
                if (i >= k - 1 && !deque.isEmpty()) {
                    result[i - k + 1] = (nums[deque.peekFirst()]);
                }
            }
            return result;
        }
    }
}
