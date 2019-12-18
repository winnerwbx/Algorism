package StackAndQueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            if (s.equals("")) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (stack.empty()) {
                    stack.push(c);
                } else {
                    if (pair(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            return stack.isEmpty();
        }

        public boolean pair(char left, char right) {
            return left == '(' && right == ')'
                    || left == '[' && right == ']'
                    || left == '{' && right == '}';
        }
    }
}
