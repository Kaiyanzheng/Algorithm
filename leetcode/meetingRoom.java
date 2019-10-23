package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class meetingRoom {

    public static List<int[]> minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = Integer.MAX_VALUE;
        int e = 0;
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
            s = Math.min(s, interval[0]);
            e = Math.max(e, interval[1]);
        }
        List<int[]> res = new ArrayList<>();
        int count = 0; // 重叠的inverval个数
        int head = 0;  // 不重叠的interval的起始时间
        for (int i = s; i < e; i++) {
            if (!map.containsKey(i)) continue;
            if (count == 0) {
                if (i != 0) res.add(new int[]{head, i});
                head = 0;
            }
            count += map.get(i);
            if (head == 0 && count == 0) head = i;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 3}, {6, 8}, {7, 9}, {12, 14}};
        List<int[]> res = minMeetingRooms(intervals);
//        for (int[] interval : res) {
//            System.out.println(interval[0] + "," + interval[1]);
//        }

        int[][] intervals1 = new int[][]{{1, 3}, {4, 5}, {5, 7}, {9, 11}, {2, 8}, {6, 10}};
        List<int[]> res1 = minMeetingRooms(intervals1);
        for (int[] interval : res1) {
            System.out.println(interval[0] + "," + interval[1]);
        }
    }
}

