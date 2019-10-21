package foundation.stack;

public interface IArrayStack<E> {

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
     * 插入数据，入栈
     * @param e
     */
    void push(E e);

    /**
     * 删除元素，出栈
     * @return
     */
    E pop( );

    /**
     * 查看栈顶
     * @return
     */
    E peek( );

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
