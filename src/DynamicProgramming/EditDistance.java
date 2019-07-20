package DynamicProgramming;

class EditDistance {
    /**
     * 72. Edit Distance
     * <p>
     * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
     * <p>
     * You have the following 3 operations permitted on a word:
     * <p>
     * Insert a character
     * Delete a character
     * Replace a character
     * Example 1:
     * <p>
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explanation:
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     * Example 2:
     * <p>
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     * Explanation:
     * intention -> inention (remove 't')
     * inention -> enention (replace 'i' with 'e')
     * enention -> exention (replace 'n' with 'x')
     * exention -> exection (replace 'n' with 'c')
     * exection -> execution (insert 'u')
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            char[] w1a = word1.toCharArray();
            char[] w2a = word2.toCharArray();
            //init
            for (int i = 0; i < m + 1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < n + 1; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (w1a[i - 1] == w2a[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int rep = dp[i - 1][j - 1] + 1;
                        int rem = dp[i - 1][j] + 1;
                        int add = dp[i][j - 1] + 1;
                        dp[i][j] = Math.min(Math.min(rep, rem), add);
                    }
                }
            }
            return dp[m][n];
        }
    }
}