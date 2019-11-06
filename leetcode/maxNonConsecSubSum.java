package leetcode;

public class maxNonConsecSubSum {

    /** sorted array */
    public static int maxNonConsecSubSum (int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[nums.length - 1];
        int[] sums = new int[max + 1];
        for (int num : nums) sums[num] += num;
//        int[] dp = new int[sums.length];
//        for (int i = 0; i < sums.length; i++) {
//            dp[i] = Math.max((i > 1 ? dp[i - 2] : 0) + sums[i],
//                             (i > 0 ? dp[i - 1] : 0));
//        }
//        return dp[dp.length - 1];
        int preMax = 0;
        int curMax = 0;
        for (int sum : sums) {
            int tmp = Math.max(preMax + sum, curMax);
            preMax = curMax;
            curMax = tmp;
        }
        return curMax;
    }

    /** unsorted array */
    public static int maxNonConsecSubSum3 (int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = -1;
        for (int num : nums) max = Math.max(max, num);
        int[] sums = new int[max + 1];
        for (int num : nums) sums[num] += num;
        int preMax = 0;
        int curMax = 0;
        for (int sum : sums) {
            int tmp = Math.max(preMax + sum, curMax);
            preMax = curMax;
            curMax = tmp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(maxNonConsecSubSum(nums)); // 6
        int[] nums1 = new int[]{1, 2, 2, 2, 2, 4};
        System.out.println(maxNonConsecSubSum(nums1)); // 12
        int[] nums2 = new int[]{1, 1, 2, 2, 2, 2, 2, 3, 3};
        System.out.println(maxNonConsecSubSum(nums2)); // 10
        int[] nums3 = new int[]{1, 1, 2, 2, 2, 2, 2, 3, 3, 4};
        System.out.println(maxNonConsecSubSum(nums3)); // 14

        int[] nums4 = new int[]{3, 2, 1, 1, 2, 1};
        System.out.println(maxNonConsecSubSum3(nums4)); // 6
        int[] nums5 = new int[]{2, 4, 2, 2, 2, 1};
        System.out.println(maxNonConsecSubSum3(nums5)); // 12
        int[] nums6 = new int[]{1, 3, 2, 2, 3, 2, 2, 2, 1};
        System.out.println(maxNonConsecSubSum3(nums6)); // 10
        int[] nums7 = new int[]{2, 2, 1, 1, 2, 2, 4, 2, 3, 3};
        System.out.println(maxNonConsecSubSum3(nums7)); // 14
    }
}
