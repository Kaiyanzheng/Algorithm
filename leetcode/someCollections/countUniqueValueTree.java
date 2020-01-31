package leetcode.someCollections;

public class countUniqueValueTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int value) {
            val = value;
            left = right = null;
        }
    }

    private static int count;

    private static int countUniqueValueTree(TreeNode root) {
        helper(root);
        return count;
    }

    public static boolean helper (TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left == false || right == false) return false;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        count++;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(countUniqueValueTree(root));
    }
}
