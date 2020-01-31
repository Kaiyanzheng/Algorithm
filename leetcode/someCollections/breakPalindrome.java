package leetcode.someCollections;

public class breakPalindrome {
    /**
     * 把第一个不是a 的字母换成a, 并且换完不是palindrome
     * 给一个palidrome 问怎么变可以让palidrome变成非palidrome 并且lexicoorder最小
     */
    public static String breakPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return "";
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] - 'a' > 0) {
                c[i] = 'a';
                count++;
                break;
            }
        }
        String ns = String.valueOf(c);
        return (count == 0 || isPalindrome(ns, 0, ns.length() - 1)) ? "IMPOSSIBLE" : ns;
    }
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
