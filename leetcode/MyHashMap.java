package leetcode;

public class MyHashMap {

    /** Resolve collisions using linked list
     * For simplicity, are the keys integers only?
     * For collision resolution, can we use chaining?
     * Do we have to worry about load factors?
     * Can we assume inputs are valid or do we have to validate them?
     * Can we assume this fits memory?
     * */

    private final ListNode[] nodes;

    /** Convert a non-uniform distribution dataset to a uniform distribution data, so that the collision rate can be lowered */
    private int hash(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    public MyHashMap() {
        nodes = new ListNode[10000];
    }

    public void put(int key, int value) {
        int i = hash(key);
        if (nodes[i] == null) nodes[i] = new ListNode(-1, -1); // dummy head then do not need to check null pointers when find and delete
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get(int key) {
        int i = hash(key);
        if (nodes[i] == null) return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = hash(key);
        if (nodes[i] == null) return;
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    private ListNode find(ListNode bucket, int key) {
        ListNode node = bucket;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }


    class ListNode {

        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
    }

}
