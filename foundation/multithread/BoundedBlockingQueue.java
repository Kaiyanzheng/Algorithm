package foundation.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private ReentrantLock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();
    private int[] data;
    private int tail = 0;
    private int head = 0;
    private volatile int size = 0;

    public BoundedBlockingQueue(int capacity) {
        data = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size == data.length) {
                isFull.await();
            }
            data[tail++] = element;
            tail %= data.length;
            size++;
            isEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                isEmpty.await();
            }
            int res = data[head++];
            head %= data.length;
            size--;
            isFull.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return this.size;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue test = new BoundedBlockingQueue(5);
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        int i = test.dequeue();
        System.out.println(i);
        int j = test.dequeue();
        System.out.println(j);
    }
}
