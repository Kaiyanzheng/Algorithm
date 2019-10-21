package foundation.stack.impl;

public class Main {

    public static void main(String[] args) {
        ArrayStackImpl<Integer> stack = new ArrayStackImpl<>();
        stack.push(1);
        stack.print();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());
        stack.print();
        //stack.pop();
        int x = stack.pop();
        System.out.println(x);
        stack.print();
    }
}
