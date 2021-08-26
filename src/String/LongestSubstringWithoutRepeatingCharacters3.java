package String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            if (length == 0) {
                return 0;
            }
            int left = 0, right = 0;
            int maxCount = 0;
            Map<Character, Integer> mp = new HashMap<>();
            while (right < length && left <= right) {
                if (!mp.containsKey(s.charAt(right))) {
                    mp.put(s.charAt(right), 1);
                    maxCount = Math.max(maxCount, mp.size());
                    right++;
                } else {
                    mp.remove(s.charAt(left));
                    left++;
                }
            }
            return maxCount;
        }
    }
}
