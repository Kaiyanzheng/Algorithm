package jobPrep2019.amazon.eight;

import java.util.List;
import java.util.PriorityQueue;

public class mergeStone {
    /**
     *  merger stones/files, [1 1 2] -> [2 2] -> [4]
     *  if needs to merger consecutive K stones every time, use this method
     *  we have a 2D matrix dp, dp[i][j] means merge stone_i to stone_j into one pile;
     *  m means the number of stones to merge, we first calculate from K stones, then to len stones,
     *  then for dp[i][j] = Math.min(dp[i][mid] + dp[mid+1][j]), i <= mid < j
     *
     *  time: O(n^3)
     */

    public int mergeStones(int[] stones, int K) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int len = stones.length;
        if ((len - 1) % (K - 1) > 0) {
            return -1;
        }
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        int[][] dp = new int[len][len];

        for (int m = K; m <= len; m++) {
            for (int i = 0; i + m <= len; i++) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }
        return dp[0][len - 1];
    }
    /**
     * if just to choose any two of stones to merge, use minheap
     */
    public int merge(List<Integer> list) {
        if (list == null || list.size() == 0) return 0;
        if (list.size() == 1) return list.get(0); //return 0,看题目要求
        int res = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer num : list) {
            queue.offer(num);
        }

        while (queue.size() >= 2) {
            int first = queue.poll();
            int second = queue.poll();
            res += (first + second);
            queue.offer(first + second);
        }
        return res;
    }

}
