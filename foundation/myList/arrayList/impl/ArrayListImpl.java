package foundation.myList.arrayList.impl;

import foundation.myList.arrayList.IArrayList;

public class ArrayListImpl<E> implements IArrayList<E>{

    private E[] data;

    private int size;

    //无参数的构造函数
    public ArrayListImpl() {
        this(10);
    }

    //有参数的构造函数
    public ArrayListImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public int capacity() {
        return data.length;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * time: O(n)
     * @return
     */
    @Override
    public void add(E element) {
        add(size, element); //减少复用
    }

    /**
     * time: O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index输入错误（小于0或大雨初始化容量）");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        // index后面的element向后移
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index]  = element;
        size++;
    }

    /**
     * time:O(n)
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) { // 不能是i < data.length,因为初始化后data为空
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(1)
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index输入错误（小于0或大雨初始化容量）");
        }
        return data[index];
    }

    /**
     * time:O(1)
     * @param index
     * @param element
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index输入错误（小于0或大雨初始化容量）");
        }
        data[index] = element;
    }

    /**
     * O(n)
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index输入错误（小于0或大雨初始化容量）");
        }
        E res = data[index];
        //从index之后开始，每个元素往前移
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        // lazy
        if (data.length / 4 == size && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return res;
    }

    /**
     * O(n)
     * @param element
     */
    @Override
    public void remove(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("element not exits");
        }
        remove(index);
    }

    @Override
    public void print() {
        System.out.println("size: " + size);
        System.out.println("capacity: " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    /**
     * time: O(n)
     * @param capacity
     */
    @Override
    public void resize(int capacity) {
        //10个，加入1个，10*2 = 20
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
