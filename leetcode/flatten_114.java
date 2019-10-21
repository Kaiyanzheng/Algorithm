package leetcode;

import com.sun.source.tree.Tree;

public class flatten_114 {
    /** [1,2,5,3,4,null,6]
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * [1,null,2,null,3,null,4,null,5,null,6]
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

    public static void main(String[] args) {
        flatten_114 sol = new flatten_114();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        sol.flatten(t1);
    }
}
