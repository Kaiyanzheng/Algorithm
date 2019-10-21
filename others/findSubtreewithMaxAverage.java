package jobPrep2019.amazon.other;

public class findSubtreewithMaxAverage {
    class TreeNode {
        public int val;
        public  TreeNode left;
        public  TreeNode right;
        public  TreeNode (int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    TreeNode ans = null;
    int findSubtreeWithMaxAverageHelper(TreeNode node) {
        if (node == null) return 0;
        int left = findSubtreeWithMaxAverageHelper(node.left);
        int right = findSubtreeWithMaxAverageHelper(node.right);

        int curr = left + right + node.val;
        if (curr < Math.min(left, right) || ans == null) {
            ans = node;
            return curr;
        }
        return Math.min(left, right);
    }

    TreeNode findSubtreeWithMaxAverage(TreeNode root) {
        findSubtreeWithMaxAverageHelper(root);
        return ans;
    }
}
