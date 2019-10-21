package leetcode;

import java.util.Stack;

public class removeDuplicates_1047 {

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "abbaca";
        String res = removeDuplicates(S);
        System.out.println(res);
    }
}
