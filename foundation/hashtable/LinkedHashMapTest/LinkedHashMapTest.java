package foundation.hashtable.LinkedHashMapTest;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16,0.75f,true);
        linkedHashMap.put("1", "1");
        linkedHashMap.put("2", "1");
        linkedHashMap.put("3", "1");
        linkedHashMap.put("4", "1");
        print(linkedHashMap);
        linkedHashMap.get("1"); // 1 最新取用，放到最前面，LRUCache
        print(linkedHashMap);
    }

    public static void print(LinkedHashMap<String, String> linkedHashMap) {
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + "\t");
        }
        System.out.println();
    }
}


