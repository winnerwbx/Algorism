package Sort;

import org.junit.Test;

public class SortArrayByParityTest {
    @Test
    public void test() {
        int[] input = new int[]{3,1,2,4};
        SortArrayByParity.Solution s = new SortArrayByParity.Solution();
        int[] output= s.sortArrayByParity(input);
        for (int i : output) {
            System.out.println(i);
        }
    }
}