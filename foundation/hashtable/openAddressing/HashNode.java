package foundation.hashtable.openAddressing;

public class HashNode<K, V> {

    public K key;

    public V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}