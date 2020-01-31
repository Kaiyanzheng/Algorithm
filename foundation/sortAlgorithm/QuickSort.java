package foundation.sortAlgorithm;

import java.util.Arrays;
import java.util.Random;


public class QuickSort {

    /**
     * TIME:
     * best: O(nlogn)
     * worst: O(n^2)
     * avg: O(nlogn)
     *
     * SPACE: O(logn ~ n)
     *
     * 稳定性：
     *
     * @param nums
     * @param left
     * @param right
     */

    public static void quickSort (int[] nums, int left, int right) {
        if (left < right) {
            int idx = partition(nums, left, right);
            quickSort(nums, left, idx - 1);
            quickSort(nums, idx + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int idx = left; // pivot idx
        int pivot = nums[idx];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, idx, r);
        return r;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        quickSort(nums, 0, nums.length - 1);

    }
}
