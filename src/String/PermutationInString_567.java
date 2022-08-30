package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString_567 {
    public static void main(String[] args) {
        PermutationInString_567 a = new PermutationInString_567();
        a.checkInclusion("abcdxabcde", "abcdeabcdx");
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;
            // update window
            if (need.containsKey(c)) {
                window.compute(c, (k, v) -> v == null ? 1 : v + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // shrink window
            while (right - left >= s1.length()) {
                if (valid == need.size() && right - left == s1.length()) {
                    return true;
                }
                Character d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.compute(d, (k, v) -> v - 1);
                }
            }
        }
        return false;
    }
}
