package jobPrep2019.amazon.eight;

import java.util.ArrayList;
import java.util.List;

public class partitionLabel {
    /**
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     * time: O(n)
     */

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0) return res;

        int[] index = new int[26];  // record the end index of the each char
        for(int i = 0; i < S.length(); i++){
            index[S.charAt(i)-'a'] = i;
        }

        int right = 0;
        int left = 0;
        for(int i = 0; i < S.length(); i++){
            right = Math.max(right, index[S.charAt(i)-'a']); // record end index of current substring
            if(i == right){
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}
