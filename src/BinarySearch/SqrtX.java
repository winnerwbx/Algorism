package BinarySearch;

class SqrtX {

    /**
     * https://leetcode.com/problems/sqrtx/
     * #69
     */
    class Solution {
        public int mySqrt(int x) {
            int left = 0;
            int right = x;
            while (left < right) {
                // 取右中位数，如果是左中位数，则用(left + right) >>> 1
                int mid = (left + right + 1) >>> 1;
                int tmp = x / mid;
                if (mid > tmp) {
                    // 先排除逻辑
                    right = mid - 1;
                } else {
                    // 左边是闭区间，所以要用右中位数
                    left = mid;
                }
            }
            return left;
        }
    }
}