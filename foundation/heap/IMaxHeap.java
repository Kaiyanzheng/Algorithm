package foundation.heap;

public interface IMaxHeap<E> {
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
    boolean offer(E e);

    /**
     * 删除元素，出队列
     * @return
     */
    E poll( );

    /**
     * 查看队列顶
     * @return
     */
    E peek( );

    /**
     * 打印数据和结果
     */
    void print();
}
