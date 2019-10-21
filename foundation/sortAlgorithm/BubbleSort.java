package foundation.sortAlgorithm;

import java.util.Arrays;


public class BubbleSort {

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
    public static void bubbleSort (int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("当前第" + (i+1) + "轮状态" + Arrays.toString(nums));
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                System.out.println("第" + (i + 1) + "轮步骤" + Arrays.toString(nums));
            }
        }
    }

    /**
     * 优化，BEST TO BE O(n)
     * 设置全局变量
     */

    public static void bubbleSortBest (int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            System.out.println("当前第" + (i+1) + "轮状态" + Arrays.toString(nums));
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
                System.out.println("第" + (i + 1) + "轮步骤" + Arrays.toString(nums));
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 2, 9, 4, 7, 6, 1, 3, 8};
        int[] nums2 = new int[] {1, 2, 3, 4, 5, 6};
        bubbleSortBest(nums2);
    }
}
