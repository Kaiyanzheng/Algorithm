package leetcode;

import java.util.*;

public class _692_topKFrequent {
    // Time: O(nlogn), Space: O(n)

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) return s2.compareTo(s1);
                return map.get(s1) - map.get(s2);
            }
        });
        //System.out.println(map); //{love=2, coding=1, i=2, leetcode=1}

        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        //System.out.println(pq); //[i, love]

        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        _692_topKFrequent sol = new _692_topKFrequent();
        String[] words2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}; // ["the", "is", "sunny", "day"]
        String[] words1 = new String[] {"i", "love", "leetcode", "i", "love", "coding"}; // ["i","love"]
        int k = 4;
        //sol.topKFrequent(words1, k);
        System.out.println(sol.topKFrequent(words2, k));
    }
}


