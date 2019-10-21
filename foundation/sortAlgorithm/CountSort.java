package foundation.sortAlgorithm;

import java.util.Arrays;

public class CountSort {
    /**
     * TIME:
     * best:O(n), worst:无意义, avg: O(n+k) k: 整数的范围
     * SPACE: O(k)
     * 稳定性：稳定
     */

    public static void countSort(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] +=  1;
        }

        System.out.println(Arrays.toString(count));

        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8, 16, 2};
        countSort(nums);
    }
}
