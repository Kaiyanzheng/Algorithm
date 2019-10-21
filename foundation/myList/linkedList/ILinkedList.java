package foundation.myList.linkedList;

public interface ILinkedList<E> {

    /**
     * 占用大小
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 按index插入
     * @param index
     * @param data
     */
    void add(int index, E data);

    /**
     * 正常插入
     * @param data
     * @return
     */
    boolean add(E data);

    /**
     * 头部插入
     * @param data
     */
    void addFirst(E data);

    /**
     * 尾部插入
     * @param data
     */
    void addLast(E data);

    /**
     * 头部删除
     * @return
     */
    E removeFirst();

    /**
     * 尾部删除
     * @return
     */
    E removeLast();

    /**
     *删除指定元素
     * @param data
     * @return
     */
    boolean remove(E data);

    /**
     *按index删除
     * @param index
     */
    E remove(int index);

    /**
     * 拿到指定元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 拿到第一个元素
     * @return
     */
    E getFirst();

    /**
     * 拿到最后一个元素
     * @return
     */
    E getLast();

    /**
     * 更改指定元素
     * @param index
     * @param data
     * @return
     */
    void set(int index, E data);

    /**
     * 查看是否包含此函数
     * @param data
     * @return
     */
    boolean contains (E data);

    /**
     * 打印链表
     */
    void print();

}

