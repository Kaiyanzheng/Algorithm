package foundation.sortAlgorithm;

import java.util.Arrays;

public class MergeSort {

    /**
     * TIME:
     * best: O(nlogn)
     * worst: O(nlogn)
     * avg: O(nlogn)
     *
     * SPACE: O(n)
     *
     * 稳定性：稳定
     * 315. Count of Smaller Numbers After Self
     */
    public static int[] mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = nums[l + i];
        for (int j = 0; j < n2; j++) R[j] = nums[mid + 1 + j];

        int i = 0, j = 0; // Initial indexes of first and second sub array
        int k = l;     // Initial index of merged sub array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) nums[k] = L[i++];
            else nums[k] = R[j++];
            k++;
        }
        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];

        //System.out.println("当前排序结果: " + Arrays.toString(nums));
    }

    public static void merge2(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int x = 0; x < temp.length; x++) {
            nums[x + left] = temp[x];
        }

        System.out.println("当前排序结果: " + Arrays.toString(nums));
    }



    public static void main(String[] args) {
        int[] nums = new int[] {5, 2, 9, 4, 7, 6, 1, 3, 8};
        mergeSort(nums, 0, nums.length - 1);
    }
}
