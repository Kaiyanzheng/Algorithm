package foundation.sortAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    /**
     * TIME:
     * n:待排序的数据
     * m: 桶
     * best: O(n)
     * worst: 无意义
     * avg: O(n + c), c = n * (logn ~ logm)
     *
     * SPACE: O(n + m)
     *
     * 稳定性：稳定
     *
     * @param nums
     */
    public static void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int bucketNum = (max - min) / nums.length + 1;
        System.out.println("max, min, " + max + ", " + min + " bucketNum: " + bucketNum);
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
        }

        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        System.out.println(bucket.toString());

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8, 16};
        bucketSort(nums);
    }
}
