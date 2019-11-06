package leetcode;

import java.util.ArrayList;
import java.util.List;

public class pathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<List<Integer>> res;

    public static int pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) return 0;
        List<Integer> path = new ArrayList<>();
        return helper(root, 0, sum, path) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private static int helper(TreeNode node, int cur, int sum, List<Integer> path) {
        if (node == null) return 0;
        cur += node.val;
        path.add(node.val);
        int count = (node.val == sum ? 1 : 0) + helper(node.left, cur, sum - node.val, path) + helper(node.right, cur, sum - node.val, path);
        if (cur == sum) res.add(path);
        path.remove(path.size() - 1);
        return count;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int sum = 8;
        int count = pathSum(root, sum);
        for (List<Integer> path : res) {
            for (Integer p : path) {
                System.out.print(p + ", ");
            }
            System.out.println(" ");
        }
    }
}
