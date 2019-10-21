package foundation.myList.arrayList;

public interface IArrayList<E> { // <E>可以是任何类型 -- 范型

    /**
     * 容量大小
     */

    int capacity();

    /**
     * 实际占用大小
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 加入：末尾
     * @param element
     */
    void add(E element);

    /**
     * 加入：中间插入
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 查找元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 找到元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 修改元素
     * @param index
     * @param element
     */
    void set(int index, E element);

    /**
     * 根据index查找删除
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 找到元素进行删除
     * @param element
     */
    void remove(E element);

    /**
     * 打印数据和结果
     */
    void print();

    /**
     * 改变capacity的大小
     * @param capacity
     */
    void resize(int capacity);
}
