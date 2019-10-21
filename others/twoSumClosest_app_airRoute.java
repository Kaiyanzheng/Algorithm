package jobPrep2019.amazon.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class twoSumClosest_app_airRoute {
    /**
     * two sum closest
     * 给两个int的list，一个capacity，从两个list中各选一个item把num加和，返回所有pair里小于capacity并且最大的id，有多个就返回多个
     * list是这个格式的：[[id1, num1], [id2, num2], [id3, num3]]
     * 返回的格式是：[[id, id], ...]
     *
     * 比如给 20, [[1, 8], [2, 7]], [[1, 9], [2, 16]] 返回 [1, 1], id1为1的前端应用需要的内存是8，id2为1的后端应用内存是9
     * 加起来是最大的且小于最大内存（20）的pair了。
     * 这‍‌‌‍‌‍‌‍‍‌‌‌‍‌‌‌‍‌‍里要注意相等的情况，所有和为最佳内存和的pair都要返回
     *
     * 用枚举，注意不要使用２sum closed 就暴力ｎ＊ｎ, 2sum closed 无法处理重‍‌‌‍‌‍‌‍‍‌‌‌‍‌‌‌‍‌‍复数据　后面的Case通过不了
     */
    public List<List<Integer>> utilization(int[][] fore, int[][] back, int capacity) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int[] pair : back) {
            List<Integer> list = treeMap.getOrDefault(pair[1], new ArrayList<>());
            list.add(pair[0]);
            treeMap.put(pair[1], list);
        }

        TreeMap<Integer, List<List<Integer>>> res = new TreeMap<>();
        for (int[] pair : fore) {
            Integer floorKey = treeMap.floorKey(capacity - pair[1]);
            if (floorKey != null) {
                int diff = capacity - pair[1] - floorKey;
                List<List<Integer>> list = res.getOrDefault(diff, new ArrayList<>());
                for (int id : treeMap.get(floorKey)) {
                    List<Integer> match = new ArrayList<>();
                    match.add(pair[0]);
                    match.add(id);
                    list.add(match);
                }
                res.put(diff, list);
            }
        }
        return res.get(res.firstKey());
    }

    public List<List<Integer>> utilization(List<List<Integer>> fore, List<List<Integer>> back, int capacity) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < back.size(); i++) {
            List<Integer> list = treeMap.getOrDefault(back.get(i).get(1), new ArrayList<>());
            list.add(back.get(i).get(0));
            treeMap.put(back.get(i).get(1), list);
        }

        TreeMap<Integer, List<List<Integer>>> res = new TreeMap<>();
        for (int i = 0; i < fore.size(); i++) {
            Integer floorKey = treeMap.floorKey(capacity - fore.get(i).get(1));
            if (floorKey != null) {
                int diff = capacity - fore.get(i).get(1) - floorKey;
                List<List<Integer>> list = res.getOrDefault(diff, new ArrayList<>());
                for (int id : treeMap.get(floorKey)) {
                    List<Integer> match = new ArrayList<>();
                    match.add(fore.get(i).get(0));
                    match.add(id);
                    list.add(match);
                }
                res.put(diff, list);
            }
        }
        return res.get(res.firstKey());
    }

    public static void main(String[] args) {
        twoSumClosest_app_airRoute sol = new twoSumClosest_app_airRoute();
        //int capacity = 10000;
        //int[][] fore = new int[][] {{1,7000}, {2,5000}, {3,3000}, {4,10000}};
        //int[][] back = new int[][] {{1,2000}, {2,4000}, {3,3000}, {4,5000}};
        int capacity = 20;
//        int[][] fore = new int[][] {{1, 8}, {2, 7}, {3, 8}};
//        int[][] back = new int[][] {{1, 9}, {2, 16}, {3, 9}};
        List<List<Integer>> fore = new ArrayList<>();
        List<Integer> f1 = new ArrayList<>();
        f1.add(1);
        f1.add(8);
        fore.add(f1);
        List<Integer> f2 = new ArrayList<>();
        f2.add(2);
        f2.add(7);
        fore.add(f2);
        List<Integer> f3 = new ArrayList<>();
        f3.add(3);
        f3.add(8);
        fore.add(f3);

        List<List<Integer>> back = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        b1.add(1);
        b1.add(9);
        back.add(b1);
        List<Integer> b2 = new ArrayList<>();
        b2.add(2);
        b2.add(16);
        back.add(b2);
        /*List<Integer> b3 = new ArrayList<>();
        b3.add(3);
        b3.add(9);
        back.add(b3);*/

        List<List<Integer>> res = sol.utilization(fore, back, capacity);
        for (List<Integer> li : res) {
            System.out.println(li);
        }
    }

}
