package leetcode;

public class _494_findTargetSumWays {
    public int findTargetSumWays(int[] nums, int s) { // num = 1 2 3, s = 4, sum = 6
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < s || (s + sum) % 2 != 0) {
            return 0;
        } else {
            return subsetSum(nums, (s + sum) >>> 1); // subsetSun(nums, 10 / 2 = 5)
        }
    }
    public int subsetSum(int[] nums, int x) { // x = 5
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = x; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[x];
    }

    public static void main(String[] args) {
        _494_findTargetSumWays sol = new _494_findTargetSumWays();
        int[] nums = new int[]{1, 1, 1};
        int s = 1;
        System.out.println(sol.findTargetSumWays(nums, s));
    }
}
