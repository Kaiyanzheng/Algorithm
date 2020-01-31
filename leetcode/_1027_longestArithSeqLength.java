package leetcode;

import java.util.HashMap;

public class _1027_longestArithSeqLength {
    /**
     * /*dp[diff][index] equals to the length of arithmetic sequence at index with difference diff.
     *          [3, 5, 9, 12]
     *          i = 0 dp[0]:{}
     *          i = 1, j = 0, diff = 2, dp[1]: 2, 1    dp[1]: {3=2}
     *          i = 2,    dp:{3=3, 6=2}
     *          i = 3: dp: {3=4, 6=2, 9=2}
     *
     */
    public static int longestArithSeqLength(int[] A) {

        int res = 2;
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 6, 9, 12};
        longestArithSeqLength(A);
    }
}
