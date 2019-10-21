package foundation.sortAlgorithm;

import java.util.Arrays;


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
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, pivotIndex, r);
        return r;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        quickSort(nums, 0, nums.length - 1);

    }
}
