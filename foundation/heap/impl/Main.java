package foundation.heap.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void compare1() {
        // 升序排列，最小堆
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (Integer num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void compare2() {
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void compare3() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });

        String[] strings = new String[]{"12", "23"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o1;
                return s1.compareTo(s2);
            }
        });
    }

    public static void compare4() {
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(5, (a, b) -> (a.a - b.a));
        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
    }

    class Node {
        int a;
        int b;
    }

    public static void main(String[] args) {
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        int[] nums = new int[]{2, 23, 30, 8, 32, 31, 41, 1, 15};
        /**
         * nlog(n)
         */
        for (int num : nums) {
            maxHeap.offer(num);
        }
        //maxHeap.print();

        compare1();

        compare2();


        PriorityQueue<Student> priorityQueue2 = new PriorityQueue<>((a, b) -> (a.score - b.score)) ;



    }

    class Student {
        int score;
    }
}
