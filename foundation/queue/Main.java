package foundation.queue;

import foundation.queue.impl.ArrayCircularOfQueueImpl;
import foundation.queue.impl.ArrayOfQueueImpl;
import foundation.queue.impl.LinkedListOfQueueImpl;

public class Main {

    public static void testLinkedListOfQueue() {
        MyQueue<Integer> queue = new LinkedListOfQueueImpl<>();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayOfQueue() {
        MyQueue<Integer> queue = new ArrayOfQueueImpl<>();
        for (int i = 0; i < 11; i++) {
            queue.offer(i);
            queue.print();
        }
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayCircularOfQueue() {
        MyQueue<Integer> queue = new ArrayCircularOfQueueImpl<>();
        for (int i = 0; i < 9; i++) {
            queue.offer(i);
        }
        queue.print();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.print();
        queue.offer(11);
        queue.offer(21);
        queue.offer(31);
        queue.offer(41);
        queue.print();
    }

    public static void main(String[] args) {
        testArrayCircularOfQueue();
    }
}
