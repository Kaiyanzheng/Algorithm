package leetcode;

import foundation.tree.tranversal.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class distanceK_863 {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().val + " : " + entry.getValue());
        }
        dfs(root, target, K, map.get(root), res);

        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left != -1) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right != -1) {
            map.put(root, right + 1);
            return right + 1;
        }

        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(4);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t4.left = t7;
        t4.right = t8;

        distanceK_863 sol = new distanceK_863();
        System.out.println(sol.distanceK(root, t1, 2));
    }
}
