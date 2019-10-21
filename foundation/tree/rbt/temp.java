package foundation.tree.rbt;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class temp {

    public static void main(String[] args) {
        /**
         * 红黑树实现，用中序遍历
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1, 5);
        map.put(5, 5);
        map.put(2, 5);
        map.put(4, 6);
        map.put(3, 5);

        System.out.println(map.ceilingKey(3)); // >=
        System.out.println(map.floorKey(3)); // <=

        System.out.println(map.higherKey(3)); // >
        System.out.println(map.lowerKey(3)); // <

        Map.Entry<Integer, Integer> entry = map.higherEntry(3);
        System.out.println(entry.getValue());

/*        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }*/
    }
}
