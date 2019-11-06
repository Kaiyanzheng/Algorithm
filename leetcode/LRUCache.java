package leetcode;

import java.util.HashMap;

public class LRUCache {
    /**
     * O(1)
     *
     * get(key)- Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     *          -> hashMap
     *
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *          -> Double Linked List (remove the last entry, add/move an entry to the front)
     */

    class DLLNode {

        int key;
        int val;
        DLLNode next;
        DLLNode prev;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public int capacity;

    public HashMap<Integer, DLLNode> map;

    public DLLNode head;

    public DLLNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLLNode node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLLNode node = map.get(key);
            node.val = value;
            if (head.next.key != key) moveToHead(node);
        } else {
            DLLNode node = new DLLNode(key, value);
            map.put(key, node);
            if (map.size() > this.capacity) {
                DLLNode rm = tail.prev;
                remove(rm);
                map.remove(rm.key);
            }
            insertHead(node);
        }
    }

    public void remove(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertHead(DLLNode node) {
        DLLNode nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public void moveToHead(DLLNode node) {
        remove(node);
        insertHead(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);                  // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4);                  // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
