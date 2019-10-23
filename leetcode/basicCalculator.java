package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class basicCalculator {
    /** LC 772 + 求幂
     * 给一个String,包含空格， 加减乘除括号，求幂。。比如 '3+ 2 ^（3* 2-3^  1)' = 11
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        // queue 的 offer 和 poll 复杂度都是O(1)，substring 是 O(n)
        queue.offer('+'); // 保证最后一个数进栈
        return dfs(queue);
    }
    private int dfs(Queue<Character> queue) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) num = 10 * num + c - '0';
            // 计算顺序是从最里面的括号开始，所以用dfs
            if (c == '(') num = dfs(queue);
            if (!Character.isDigit(c) && c != ' '){
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);
                if (sign == '^') stack.push((int)(Math.pow(stack.pop(), num)));
                sign = c;
                num = 0;
                if (c == ')') break;
            }
        }
        int res = 0;
        for (int n : stack) res += n;
        return res;
    }

    public static void main(String[] args) {
        basicCalculator sol = new basicCalculator();
        System.out.println(sol.calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
        System.out.println(sol.calculate("3 ^ 1")); // 3
        System.out.println(sol.calculate("3 + 2 ^ (3* 2-3 ^ 1)")); // 11

    }
}
