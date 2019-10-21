package foundation.tree.tranversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    /**
     * Inorder 中序遍历, recursion
     * @param root
     */

    public void inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return;
        helper(res, root);
        print(res);
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }

    /**
     * Iteration 三种迭代考的最多！
     * @param root
     */
    private void inorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
           while (cur != null) {
               stack.push(cur);
               cur = cur.left;
           }
           cur = stack.pop();
           res.add(cur.val);
           cur = cur.right;
        }
    }

    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;

        Inorder inorder = new Inorder();
        inorder.inorder2(root);
    }
}

