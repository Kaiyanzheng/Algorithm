package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class sortK {
    public List<Integer> sortK(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] > nums[j - 1]) j++;
            if (j == nums.length || nums[j] < nums[j - 1]) {
                List<Integer> sorted = new ArrayList<>();
                while (i < j) {
                    sorted.add(nums[i]);
                    nums[i] = -1;
                    i++;
                }
                //System.out.println(sorted);
                lists.add(sorted);
                j++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();

        int idx = 0;
        for (List<Integer> list : lists) {
            pq.offer(list.get(idx));
        }
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
        int[] nums0 = new int[]{1,3,4,8,7,2,6,5,9};
        int[] nums = new int[]{1,2,5,3,9,11,4,0,12};
        sortK sol = new sortK();
        List<Integer> res = sol.sortK(nums);
        for (int num : res) System.out.println(num);
    }
}
