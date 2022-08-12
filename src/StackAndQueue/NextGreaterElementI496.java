package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[nums1.length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                while (!stack.empty() && stack.peek() < nums2[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    map.put(nums2[i], -1);
                } else {
                    map.put(nums2[i], stack.peek());
                }
                stack.push(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}
