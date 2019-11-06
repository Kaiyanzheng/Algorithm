package leetcode;

import java.util.HashMap;
import java.util.Map;

public class pathSum2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     */
    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0,1);
        return helper(root, 0, sum, map);
    }

    public static int helper(TreeNode root, int cur, int sum, Map<Integer, Integer> map) {
        if (root == null) return 0;
        cur += root.val;
        int res = map.getOrDefault(cur - sum, 0);  // cur - sum = pre  ->  cur - pre = sum
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> " + map.get(key) + ", ");
        }
        System.out.println(" ");

        res += helper(root.left, cur, sum, map) + helper(root.right, cur, sum, map);
        map.put(cur, map.get(cur) - 1);
        return res;
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
        System.out.println(pathSum(root, sum));
    }
}
