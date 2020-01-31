package leetcode;

import java.util.HashMap;

public class _1010_numPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int t : time) {
            res += map.getOrDefault((60 - t % 60) % 60, 0);
            System.out.println(res);
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
            System.out.println(map);
        }
        return res;
    }

    public static void main(String[] args) {
        _1010_numPairsDivisibleBy60 sol = new _1010_numPairsDivisibleBy60();
        int[] time = new int[]{30, 20, 150, 100, 40};
        sol.numPairsDivisibleBy60(time);
    }
}
