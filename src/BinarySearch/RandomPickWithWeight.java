package BinarySearch;

import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomPickWithWeight {

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{3, 14, 1, 7});
        s.pickIndex();
    }

    static class Solution {
        private int[] weightSum;
        private Random r;

        public Solution(int[] w) {
            r = new Random();
            if (w.length == 0) {
                weightSum = new int[0];
                return;
            }
            weightSum = new int[w.length];
            weightSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                weightSum[i] = weightSum[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            // Random包括左边不包括右边
            int val = r.nextInt(weightSum[weightSum.length - 1]);
            // find index of weightSum
            int left = 0;
            int right = weightSum.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                int midVal = weightSum[mid];
                if (midVal <= val) {    // 此处用<=，因为random的值包括左边，所以第一个权重为3时，取值为0，1，2不包括3
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
