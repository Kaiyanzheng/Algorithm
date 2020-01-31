package leetcode.someCollections;

import java.util.ArrayList;
import java.util.List;

public class slidingWindowMean {

    private BSTNode root;

    List<Double> getAverage(int[] nums, int k) {
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            root = insert(nums[i], root);
        }
        res.add(computeAverage(k));
        for (int i = k; i < nums.length; ++i) {
            erase(nums[i - 1]);
            insert(nums[i + k - 1], root);
            res.add(computeAverage(k));
        }
        return res;
    }

    BSTNode insert(int num, BSTNode root) {
        if (root == null) return new BSTNode(num);
        if (root.val == num) {
            root.dup++;
            return root;
        } else if (root.val > num) {
            root.left = insert(num, root.left);
            return root;
        } else {
            root.right = insert(num, root.right);
            return root;
        }
    }

    void erase(int x) { eraseHelper(x, root); }

    BSTNode eraseHelper(int x, BSTNode curr) {
        if (curr.val == x) {
            if (curr.dup == 0) return null;
            else if (curr.dup == 1) {
                curr.dup--;
                BSTNode node = curr.right;
                while (node.left != null) {
                    node = node.left;
                }
                BSTNode tmp = node;
                node = curr;
                curr = tmp;
            } else {
                curr.dup--;
                return curr;
            }
        }
        curr.left = eraseHelper(x, curr.left);
        curr.right = eraseHelper(x, curr.right);
        return curr;
    }

    double computeAverage(int k) {
        int startIdx = k / 10, endIdx = k - 1 - k / 10;
        int cnt = 0;
        int sum = 0;
        getSum(sum, root, cnt, startIdx, endIdx);
        return sum * 1.0 / cnt;
    }

    void getSum(int sum, BSTNode curr, int cnt, int startIdx, int endIdx) {
        if (curr == null) return;
        getSum(sum, curr.left, cnt, startIdx, endIdx);
        cnt += curr.dup;
        if (cnt >= startIdx && cnt <= endIdx) sum += curr.val * curr.dup;
        getSum(sum, curr.right, cnt, startIdx, endIdx);
    }

    class BSTNode {
        int val;
        int dup;
        BSTNode left, right;
        public BSTNode(int value) {
            val = value;
            dup = 1;
            left = null;
            right = null;
        }
    }

    BSTNode find(int x) {
        BSTNode curr = root;
        while (curr != null) {
            if (curr.val < x) curr = curr.right;
            else if (curr.val > x) curr = curr.left;
            else return curr;
        }
        return curr;
    }
}
