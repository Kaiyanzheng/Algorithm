package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class serializeDeserializeTree {

    /** 1,2,null,null,3,4,null,null,5,null,null
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     */
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return buildString(new StringBuilder(), root).toString();
    }
    private static StringBuilder buildString(StringBuilder sb, TreeNode root) {
        if (root == null) return sb.append("null");
        sb.append(root.val).append(",");  // preorder
        buildString(sb, root.left).append(",");
        buildString(sb, root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        return buildTree(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    private static TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();  // Use queue to simplify position move
        if (val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        //System.out.println(serialize(root));
        String res = serialize(root);
    }

}
