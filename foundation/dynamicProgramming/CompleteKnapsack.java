package foundation.dynamicProgramming;

import java.util.Arrays;

public class CompleteKnapsack {

    /**
     * 背包问题
     * --------------------
     *      value   weight
     * A      5       5
     * B     10       2
     * C     12       4
     * D     16       4
     * ------------------------------------------------------
     *       容量0  容量1  容量2  容量3  容量4  容量5 ...... C
     * 物品A    0     0     0      0     5      5         5
     * 物品B    0     0     0      0     0      0         0
     * 物品C    0     0     0      0     0      0         0
     * 物品D    0     0     0      0     0      0          0
     * ------------------------------------------------------
     * 不放：f(i, c) = f(i - 1, c)
     *   放：f(i, c) = v(i) + f(i - 1, c - w(i)) = Max(f(i - 1, c), v(i) + f(i - 1, c - w(i)))注意不是把 1 - i 都放进去
     * 前 i 件物品恰放入一个容量为C的背包可以获得的最大价值
     * @param weight
     * @param value
     * @param C: capacity
     * @param N: number
     * @return
     */
    public int knapsack01(int[] weight, int[] value, int C, int N) {
        int[][] memo = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j < weight[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], value[i - 1] + memo[i - 1][j - weight[i - 1]]); // 比较不放的价值和放的价值
                }
            }
        }
        return memo[N][C];
    }

    public int knapsack03(int[] weight, int[] value, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 0; i < N; i++) {
            for (int j = C; j >= weight[i]; j--) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }

    public int completeKnapsack(int[] weight, int[] value, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 0; i < N; i++) {
            for (int j = weight[i]; j <= C; j--) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }

}
