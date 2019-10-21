package foundation.sortAlgorithm;

import java.util.Arrays;

public class InsertSort {
    /**
     * time: n * (n + (n-1) + (n-2) + ...) = O(n^2)
     * best: O(n)
     * worst: O(n^2)
     * average: O(n^2)
     *
     * space: O(1)
     *
     * 稳定性：稳定
     *
     * @param nums
     */

    public static void insertSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("当前第" + (i+1) + "轮状态" + Arrays.toString(nums));
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
                System.out.println("第" + (i + 1) + "轮步骤" + Arrays.toString(nums));
            }
        }
    }

    /**
     * TIME: n * (n + (n-1) + (n-2) + ...) = O(n^2)
     * best: O(nlogn)
     * worst: O(n^2)
     * average: O(n^2)
     *
     * SPACE: O(1)
     *
     * 稳定性：稳定
     *
     * @param nums
     */

    public static void insertBinarySort(int[] nums) {
        int temp; //不需要每次在FOR 循环中每次开辟新空间
        int low;
        int high;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = nums[i + 1];
            low = 0;
            high = i;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i; j > high; j--) {
                nums[j + 1] = nums[j];
            }
            nums[high + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        insertSort(nums);
    }
}
