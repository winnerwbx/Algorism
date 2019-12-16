package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("ab", "aa"));
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            char[] a = s.toCharArray();
            char[] b = t.toCharArray();
            HashMap<Character, Character> map = new HashMap<>();
            Set<Character> alreadyPut = new HashSet<>();
            for (int i = 0; i < a.length; i++) {
                if (!map.containsKey(a[i]) && !alreadyPut.contains(b[i])) {
                    map.put(a[i], b[i]);
                    alreadyPut.add(b[i]);
                } else if (map.containsKey(a[i]) && alreadyPut.contains(b[i])) {
                    if (!map.get(a[i]).equals(b[i])) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        public List<Integer> normalize(String input) {
            List<Integer> charset = input.chars().boxed().distinct().collect(Collectors.toList());
            return input.chars().boxed().map(charset::indexOf).collect(Collectors.toList());
        }

        public boolean isIsomorphic2(String s, String t) {
            int[] a = new int[256];
            int[] b = new int[256];
            for (int i = 0; i < s.length(); i++) {
                if (a[s.charAt(i)] != b[t.charAt(i)]) {
                    return false;
                }
                a[s.charAt(i)] = i + 1;
                b[t.charAt(i)] = i + 1;
            }
            return true;
        }
    }
}
