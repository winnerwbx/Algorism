/**
 * 70. Climbing Stairs
 * Easy
 * <p>
 * 2156
 * <p>
 * 80
 * <p>
 * Favorite
 * <p>
 * Share
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 **/
class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }
}