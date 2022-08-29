package BinarySearch;

public class KokoEatingBananas875 {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas875().new Solution().f(new int[]{1, 2, 3, 4, 5}, 2));
    }

    /**
     * fix int overflow bug
     */
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            if (piles.length == 0) {
                return 0;
            }
            long left = 1, right = 1000000000;
            while (left <= right) {
                long mid = left + right >>> 1;
                if (f(piles, mid) > h) {
                    left = mid + 1;
                } else if (f(piles, mid) <= h) {
                    right = mid - 1;
                }
            }
            if (right > 0 && f(piles, right) == h) {
                return (int) right;
            } else {
                return (int) right + 1;
            }
        }

        /**
         * the function for the time cost of Koko finish eating piles of bananas
         *
         * @param piles banana piles
         * @param k     is the eating speed of Koko
         * @return how many hours for Koko to eat all the bananas
         */
        private long f(int[] piles, long k) {
            if (piles.length == 0) {
                return 0;
            }
            long hours = 0;
            for (int pile : piles) {
                long count = pile / k;
                if (pile % k != 0) {
                    count++;
                }
                hours += count;
            }
            return hours;
        }
    }
}
