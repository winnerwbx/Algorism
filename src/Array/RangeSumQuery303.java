package Array;

public class RangeSumQuery303 {
    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            int len = nums.length;
            preSum = new int[len + 1];
            preSum[0] = 0;
            if (len == 0) {
                return;
            }
            for (int i = 1; i <= len; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
