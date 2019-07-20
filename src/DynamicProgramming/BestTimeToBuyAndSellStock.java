package DynamicProgramming;

class BestTimeToBuyAndSellStock {
    /**
     * 188. Best Time to Buy and Sell Stock IV
     * <p>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * <p>
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     * Example 2:
     * <p>
     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
     * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     **/
    class Solution {
        public int maxProfit(int k, int[] prices) {
            // limit discuss
            int length = prices.length;
            if (k <= 0 || length <= 0) {
                return 0;
            }
            if (k >= prices.length / 2)
                return greedy(prices);
            // define dp
            int[][][] dp = new int[length][k + 1][2];
            // init
            for (int i = 0; i <= k; i++) {
                dp[0][i][0] = 0;
                dp[0][i][1] = -prices[0];
            }
            // define dp transfer
            for (int i = 1; i < length; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j][0] = j != 0 ? Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]) : dp[i - 1][j][0];

                    dp[i][j][1] = Math.max(dp[i - 1][j][0] - prices[i], dp[i - 1][j][1]);
                }
            }

            // find max profit
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= k; j++) {
                max = Math.max(max, dp[length - 1][j][0]);

            }
            return max;
        }

        private int greedy(int[] prices) {
            int max = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            }
            return max;
        }
    }
}