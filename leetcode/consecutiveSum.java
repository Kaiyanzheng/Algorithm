package leetcode;

public class consecutiveSum {
    public static int consecutive(long num) {
        // Write your code here
        int res = 0;
        for (long i = 2; i * (i + 1) / 2 <= num; i++) {
            if ((num - i * (i + 1) / 2) % i == 0) res++;
        }
        return res;
    }
}
