package leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

public class test {

    public static String test(String S){
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            stack.push(c);
        }
        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            System.out.println(c);
            sb.append(c);
        }
        return sb.toString();
    }

    public static void test2(String s) {
        String[] words = s.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void test3() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);

        System.out.println("PriorityQueue: " + queue);
        System.out.println("The element at the head is: " + queue.poll());
        //System.out.println("The second element is: " + queue.poll());
        //System.out.println("The third element is: " + queue.poll());
        System.out.println("PriorityQueue: " + queue);
    }

    public static String test4() {
        String s = "abc";
        int j = 0;
        int i = s.length();
        return s.substring(j, i);
    }

    public static void main(String[] args) {
        String S = "abcdefg";
        String s = "    ";
        //test3();
        System.out.println(test4());
    }
}


