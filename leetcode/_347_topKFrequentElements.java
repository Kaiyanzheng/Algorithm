package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _347_topKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // bucket sort  Time: O(n), Space: O(n)
        /*  nums = [1,1,1,2,2,2,3,3,4], k = 2  return 1, 2
            map: 1=3, 2=3, 3=2, 4=1
            num = 1: freq = 3, bucket[3]={1}
            num = 2:
            num = 3:
            num = 4
        */
        HashMap<Integer, Integer> map = new HashMap<>(); // num, count
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int b = bucket.length - 1; b >= 0; b--) {
            if (bucket[b] != null) {
                for (int i = 0; i < bucket[b].size() && res.size() < k; i++) {
                    res.add(bucket[b].get(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _347_topKFrequentElements sol = new _347_topKFrequentElements();
        int[] nums = {1,1,1,2,2,2,3,3,3,4};
        int k = 2;
        List<Integer> res = sol.topKFrequent(nums, k);
        for (Integer num : res) {
            System.out.println(num);
        }
    }
}
