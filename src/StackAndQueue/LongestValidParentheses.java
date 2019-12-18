package StackAndQueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    class Solution {
        // DP solution
        public int longestValidParentheses(String s) {
            // dp[i]代表最长有效子串以index为i的字符结尾的长度
            int[] dp = new int[s.length()];
            int max = 0;
            char[] cs = s.toCharArray();
            for (int i = 1; i < cs.length; i++) {
                if (cs[i] == ')') {
                    if (cs[i - 1] == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && cs[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }

        // Stack solution
        public int longestValidParentheses2(String s) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            stack.push(-1);
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }


        // 两端遍历方式
        public int longestValidParentheses3(String s) {
            int left = 0, right = 0;
            int max = 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (left < right) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = cs.length - 1; i >= 0; i--) {
                if (cs[i] == ')') {
                    right++;
                } else {
                    left++;
                }
                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return max;
        }


    }
}
