package foundation.tree.avl.impl;

import foundation.tree.avl.AVLNode;
import foundation.tree.avl.IAVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeImpl implements IAVLTree {

    AVLNode root;

    int size;

    public AVLTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    private AVLNode add(AVLNode node, int val) {
        if (node == null) {
            size++;
            return new AVLNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("节点已存在");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private AVLNode rightRotate(AVLNode x) {
        AVLNode y = x.left;
        AVLNode C = y.right;

        y.right = x;
        x.left = C;

        //x y 顺序不能调换
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode C = y.left;

        y.left = x;
        x.right = C;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private AVLNode remove(AVLNode node, int val) {
        if (node == null) {
            return null;
        }

        AVLNode changeNode;


        if (node.val > val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if (node.val < val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {
            if (node.left == null) {
                size--;
                changeNode = node.right;
            } else if (node.right == null) {
                size--;
                changeNode = node.left;
            } else {
                AVLNode minNode = findMin(node.right);
                node.val = minNode.val;
                node.right = remove(node.right, node.val);
                changeNode = node;
            }
        }

        if (changeNode == null) {
            return null;
        }
        changeNode.height = 1 + Math.max(getHeight(changeNode.left), getHeight(changeNode.right));

        int balanceFactor = getBalanceFactor(changeNode);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) >= 0) {
            return rightRotate(changeNode);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) <= 0) {
            return leftRotate(changeNode);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) < 0) {
            changeNode.left = leftRotate(changeNode.left);
            return rightRotate(changeNode);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) > 0) {
            changeNode.right = leftRotate(changeNode.right);
            return leftRotate(changeNode);
        }

        return changeNode;
    }

    private AVLNode findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(AVLNode node) { // LC 104
        return node == null ? 0 : node.height;
    }

    private boolean isBST(AVLNode node) { // LC 98
        if (node == null) return true;
        return helper(node, null, null);
    }

    private boolean helper(AVLNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    private boolean isBalanced(AVLNode node) { // LC 110
        if (node == null) {
            return true;
        }
        return helper(node) != -1;
    }

    private int helper(AVLNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }
    // TIME: O(logn) or O(h) worst: O(n)
    private boolean contains(AVLNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        } else if (node.val > val) {
            return contains(node.left, val);
        } else if (node.val < val) {
            return contains(node.right, val);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void print() {
        int level = 0;
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("第" + (level + 1) + "层");
            for (int i = 0; i < size; i++) {
                AVLNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    System.out.println("的左孩子: " + cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println(" 的右孩子: " + cur.right.val);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        AVLTreeImpl avlTree = new AVLTreeImpl();
        avlTree.add(8);
        avlTree.add(5);
        avlTree.add(6);
       // avlTree.print();
        avlTree.add(3);
        avlTree.add(10);
        avlTree.add(9);
        avlTree.add(11);
        avlTree.add(2);
        avlTree.remove(8);
        //avlTree.add(4);
        //avlTree.add(1);
        avlTree.print();
        System.out.println("是否是BST: " + avlTree.isBST(avlTree.root));
        System.out.println("是否是Balanced: " + avlTree.isBalanced(avlTree.root));
    }
}
