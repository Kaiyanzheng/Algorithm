package leetcode.someCollections;

import java.util.LinkedList;
import java.util.Queue;

public class isValidBSTfromLevel {

    static class NodeRange {
        int val;
        int min, max;
    }

    // function to check if the given array can represent Level Order Traversal of BST
    static boolean levelOrderIsOfBST(int arr[], int n) {
        if (n == 0) return true;
        Queue<NodeRange> q = new LinkedList<>();
        int i = 0;

        // node details for the root of the BST
        NodeRange node = new NodeRange();
        node.val = arr[i++];
        node.min = Integer.MIN_VALUE;
        node.max = Integer.MAX_VALUE;
        q.add(node);

        // until there are no more elements in arr[] or queue is not empty
        while (i < n && !q.isEmpty()) {
            NodeRange temp = q.poll();
            node = new NodeRange();
            // 左子树
            if (i < n && (arr[i] < temp.val && arr[i] > temp.min)) {
                node.val = arr[i++];
                node.min = temp.min;
                node.max = temp.val;
                q.add(node);
            }

            node = new NodeRange();
            // 右子树
            if (i < n && (arr[i] > temp.val && arr[i] < temp.max)) {
                node.val = arr[i++];
                node.min = temp.val;
                node.max = temp.max;
                q.add(node);
            }
        }

        if (i == n) return true;
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int n = arr.length;
        if (levelOrderIsOfBST(arr, n)) System.out.print( "Yes");
        else System.out.print( "No");
    }
}
