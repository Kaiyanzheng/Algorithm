package foundation.string;

public class MinWindowSubstring76 {

    public static String minWindow(String s, String t) {
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int len = t.length();
        int minlen = Integer.MAX_VALUE;
        int from = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                len--;
            }
            while (len == 0) {
                if (i - j + 1 < minlen) {
                    minlen = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    len++;
                }
            }
        }
        return (minlen == Integer.MAX_VALUE) ? "" : s.substring(from, from + minlen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s, t);
    }
}
