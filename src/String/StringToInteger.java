package String;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */
public class StringToInteger {
    class Solution {
        public int myAtoi(String str) {
            if (str == null || (str = str.trim()).equals("")) {
                return 0;
            }
            char[] cs = str.toCharArray();
            int flag = 1;
            int i = 0;
            int result = 0;
            if (cs[0] == '-') {
                flag = -1;
                i++;
            } else if (cs[0] == '+') {
                i++;
            }
            for (; i < cs.length; i++) {
                int cur = cs[i] - '0';
                if (cur < 0 || cur > 9) {
                    break;
                }
                if (flag > 0 && result > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
                if (flag > 0 && result == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10) {
                    return Integer.MAX_VALUE;
                }
                if (flag < 0 && -result < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                if (flag < 0 && -result == Integer.MIN_VALUE / 10 && cur > Integer.MIN_VALUE % 10) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + cur;
            }
            return flag * result;
        }
    }
}