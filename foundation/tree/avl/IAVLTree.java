package foundation.tree.avl;

public interface IAVLTree {

    void add(int val);

    void remove(int val);

    boolean contains(int val);

    int size();

    boolean isEmpty();
}
