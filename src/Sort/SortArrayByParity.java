package Sort;

/**
 * 905. Sort Array By Parity
 * Easy
 * <p>
 * 501
 * <p>
 * 54
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    static class Solution {
        public int[] sortArrayByParity(int[] A) {
            int[] output = new int[A.length];
            int j = 0, k = A.length - 1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 0) {
                    output[j] = A[i];
                    j++;
                } else {
                    output[k] = A[i];
                    k--;
                }
            }
            return output;
        }
    }

    static class Solution2 {
        public int[] sortArrayByParity(int[] A) {
            int j = 0, k = A.length - 1;
            while (j < k) {
                if (A[j] % 2 == 1 && A[k] % 2 == 0) {
                    swap(A, j, k);
                }
                if (A[j] % 2 == 0) {
                    j++;
                }
                if (A[k] % 2 == 1) {
                    k--;
                }
            }
            return A;
        }

        public void swap(int[] A, int i, int j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

}
