package leetcode.someCollections;

import java.util.HashMap;
import java.util.Map;

public class subpalindrome {
    public static int palindrome(String s) {

        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        int left, right, i, len;
        Map<String, Boolean> map = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            map.put(s.substring(i, i + 1), true);
        }
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                map.put(s.substring(i, i + 2), true);
            } else {
                dp[i][i + 1] = 0;
            }
        }
        for (len = 3; len <= s.length(); len++) {
            for (left = 0; left <= s.length() - len; left++) {
                right = left + len - 1;
                if (s.charAt(left) == s.charAt(right) && dp[left + 1][right - 1] == 1) {
                    dp[left][right] = 1;
                    map.put(s.substring(left, right + 1), true);
                } else {
                    dp[left][right] = 0;
                }
            }
        }
        return map.size();
    }
}
