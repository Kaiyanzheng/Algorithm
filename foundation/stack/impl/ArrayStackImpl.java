package foundation.stack.impl;

import foundation.stack.IArrayStack;

import java.util.EmptyStackException;

public class ArrayStackImpl<E> implements IArrayStack<E> {

    private E[] data;

    private int elementCount;

    public ArrayStackImpl() {
        this(10);
    }

    public ArrayStackImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.elementCount = 0;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public void push(E e) {
        if (elementCount == data.length) {
            resize(data.length * 2);
        }
        data[elementCount++] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        E obj = peek();
        elementCount--;
        data[elementCount] = null;
        return obj;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        return data[elementCount - 1];
    }

    @Override
    public void print() {
        System.out.println("size: " + elementCount);
        System.out.println("capacity: " + data.length);
        for (int i = 0; i < elementCount; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void resize(int capacity) {
        //10个，加入1个，10*2 = 20
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < elementCount; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
