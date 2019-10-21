package jobPrep2019.ibm;

public class separatingStudents {
    /**
     * students in a line
     * 0: performance is above average
     * 1: performance is below average
     * 最小的swap次数使得1和0分开
     * eg. avg = [0, 1, 0, 1] -> [0, 0, 1, 1], res = 1
     * Sliding window
     * Maintain a sliding window of width, which is the number of 1's in data;
     * Find the max number of 1's, maxWin, in that window;
     * Then the remaining 0's in the window with max number of 1's, width - maxWin, is the minimum swaps to get a window of all 1's.
     * lc 1151
     */
    public int minSwaps(int[] avg) {
        if (avg.length <= 2) return 0;
        int total = 0;
        for (int d: avg) total += (d == 1 ? 1 : 0);
        if (total == 0 || total == avg.length) return 0;

        int left = 0, right = 0, count = 0, max = 0;
        while (right < avg.length) {
            if (right - left < total) {
                count += avg[right++];
            } else {
                max = Math.max(count, max);
                count -= avg[left++];
                count += avg[right++];
            }
        }
        return total - max;
    }

    public static void main(String[] args) {
        separatingStudents sol = new separatingStudents();
        int[] avg = new int[]{0, 1, 0, 1};
        int res = sol.minSwaps(avg);
        System.out.println(res);
    }
}
