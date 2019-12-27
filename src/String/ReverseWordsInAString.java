package String;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Given an input string, reverse the string word by word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class ReverseWordsInAString {
    class Solution {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            s = s.trim();
            int i = s.length() - 1;
            int j = s.length();
            while (i >= 0) {
                if (s.charAt(i) == ' ') {
                    result.append(s, i + 1, j);
                    result.append(' ');
                    while (s.charAt(i) == ' ') {
                        i--;
                    }
                    j = i + 1;
                }
                i--;
            }
            result.append(s, 0, j);
            return result.toString();
        }
    }
}
