package BinarySearch;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * #22
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen("", n, n, result);
        return result;
    }

    private void gen(String cur, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(cur);
            return;
        }
        if (left > 0) {
            gen(cur+"(", left - 1, right, result);
        }
        if (right > left) {
            gen(cur+")", left, right - 1, result);
        }
    }
}