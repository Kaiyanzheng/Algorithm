package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKList {

    public static List<Integer> mergeKList(List<List<Integer>> lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (List<Integer> list : lists) pq.offer(list.get(idx));
        idx = 1;
        while (!pq.isEmpty()) {
            res.add(pq.poll());
            for (List<Integer> list : lists) {
                if (idx < list.size()) pq.offer(list.get(idx));
            }
            idx++;
        }
        while (!pq.isEmpty()) res.add(pq.poll());
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(6);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<Integer> res = mergeKList(lists);
        for (int num : res) System.out.println(num);
    }
}

