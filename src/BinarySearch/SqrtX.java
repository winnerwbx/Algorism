package BinarySearch;

/**
 * https://leetcode.com/problems/sqrtx/
 * #69
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int min = 1;
        int max = x;
        while (true) {
            int mid = min + (max - min) / 2;
            int tmp = x / mid;
            if (mid == tmp || mid < tmp && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid < tmp) {
                min = mid;
            }
            if (mid > tmp) {
                max = mid;
            }
        }
    }
}
