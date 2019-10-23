package leetcode;

public class constructTreeFromLevel {
    /**
     * Construct the BST (Binary Search Tree) from its given level order traversal.
     *
     * Examples:
     *
     * Input : arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}
     * Output : BST:
     *         7
     *        / \
     *       4   12
     *      / \  /
     *     3  6 8
     *    /  /   \
     *   1   5   10
     */

    // function to construct a BST from its level order traversal
    static TreeNode LevelOrder(TreeNode root , int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }
        if(data <= root.val) root.left = LevelOrder(root.left, data);
        else root.right = LevelOrder(root.right, data);
        return root;
    }

    static TreeNode constructBst(int arr[], int n) {
        if(n == 0) return null;
        TreeNode root = null;
        for (int i = 0; i < n; i++) root = LevelOrder(root , arr[i]);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // function to print the inorder traversal
    static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print( root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String args[]) {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int n = arr.length;
        TreeNode root = constructBst(arr, n);
        System.out.print( "Inorder Traversal: ");
        inorderTraversal(root);
    }
}
