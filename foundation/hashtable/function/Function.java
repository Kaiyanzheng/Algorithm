package foundation.hashtable.function;

import java.util.*;

public class Function {

    public static void function(String[] dict) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : dict) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s : dict) {
            // 如果没有，PUT (S, 0)，如果有，PUT (S, GET + 1)
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : dict) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        HashMap<Integer, Integer> map = new HashMap<>();
        Hashtable<Integer, Integer> table = new Hashtable<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            table.put(nums[i],i);
            set.add(nums[i]);
        }

        System.out.println("HashMap");

        // 遍历方式
        // 1 keySet
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        // 2 entrySet 重要
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 3 value
        for (Integer num : map.values()) {
            System.out.println(num);
        }

        // 4 iterator
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("HashTable");
        // 遍历方式
        // 1 keySet 无序
        for (Integer key : table.keySet()) {
            System.out.println(key + " : " + table.get(key));
        }

        // 2 Enumeration
        Enumeration<Integer> enumeration = table.keys();
        while (enumeration.hasMoreElements()) {
            int key = enumeration.nextElement();
            System.out.println(key + " : " + table.get(key));
        }


        // 3 elements
        Enumeration<Integer> enumeration2 = table.elements();
        while (enumeration2.hasMoreElements()) {
            int value = enumeration2.nextElement();
            System.out.println(value);
        }

        // 4 iterator
        Iterator<Map.Entry<Integer, Integer>> iterator2 = table.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator2.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("HashSet");

        // 遍历方式
        // 1
        for (Integer num : set) {
            System.out.println(num);
        }

        // 2 iterator
        Iterator<Integer> iterator3 = set.iterator();
        while (iterator3.hasNext()) {
            Integer num = iterator3.next();
            System.out.println(num);
        }
    }
}
