/**
 * 52. N-Queens II
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int col, int left, int right) {
        // terminate condition
        if (row >= n) {
            count++;
            return;
        }
        int pos = ~(col | left | right) & ((1 << n) - 1);
        while (pos != 0) {
            int cur = pos & -pos; // get last bit 1
            dfs(n, row + 1, cur | col, (left | cur) << 1, (right | cur) >> 1);
            pos = pos & (pos - 1); // remove last bit 1
        }
    }
}