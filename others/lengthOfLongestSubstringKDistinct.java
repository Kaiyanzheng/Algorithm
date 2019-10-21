package jobPrep2019.amazon.other;

public class lengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int numDist = 0;
        int left = 0;
        int res = 0;

        /*
        eceba
          lr
        abce
          02
        left = 0, right = 0, numDist = 0, res = 0;
        left = 0, right = 1, numDist = 1, res = 1;
        left = 0, right = 2, numDist = 2, res = 3;
        left = 2, right = 3, numDist = 2, res = 2;
        */

        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) {
                numDist++;
            }
            if (numDist > k) {
                while (--count[s.charAt(left++)] > 0); // make sure we reduce one dist num(that count == 0) until numDist == k
                numDist--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
