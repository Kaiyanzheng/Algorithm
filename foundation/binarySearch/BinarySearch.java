package foundation.binarySearch;

import java.util.Arrays;

public class BinarySearch {

    /**
     * 递归写法
     * logn: 二分法/heap
     * TIME: O(logn)
     * SPACE: O(logn)
     *
     * @param nums
     * @param low
     * @param high
     * @param target
     */
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return mid;
        }
    }

    /**
     * 迭代写法 <=
     * 都是闭区间
     * right < target < left
     * right + 1 = left
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;  //[left, right]
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {  //[left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] < target) { //[mid + 1, right]
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("第一种 left: " +  left + " right: " + right);
        return -1;
    }

    /**
     * 迭代写法 <
     * target < left = right
     * left = right
     * 左闭右开
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;  //[left, right)
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {  //[left, mid)
                right = mid;
            } else if (nums[mid] < target) { //[mid + 1, right)
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right index " + right);
        }
        System.out.println("第二种 left: " +  left + " right: " + right);
        return -1;
    }

    /**
     * 迭代写法 left + 1 < right
     * target < left < right
     * left + 1 = right
     * 左闭右开
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;  //[left, right]
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {  //[left, mid]
                right = mid;
            } else if (nums[mid] < target) { //[mid, right]
                left = mid;
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right: " + nums[right]);
        }
        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        }
        System.out.println("第三种 left: " +  left + " right: " + right);
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 9, 10};
        System.out.println(Arrays.toString(nums) + " target: 6");
        binarySearch2(nums, 6);
    }

}
