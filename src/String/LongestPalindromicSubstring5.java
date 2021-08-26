package String;

public class LongestPalindromicSubstring5 {
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            String max = "";
            for (int i = 0; i < s.length() - 1; i++) {
                String a = palindrome(s, i, i);
                String b = palindrome(s, i, i + 1);
                String maxa = a.length() > b.length() ? a : b;
                if (max.length() < maxa.length()) {
                    max = maxa;
                }
            }
            return max;
        }

        private String palindrome(String s, int l, int r) {
            while (l >= 0 && l < s.length() && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            return s.substring(l + 1, r);
        }
    }
}
