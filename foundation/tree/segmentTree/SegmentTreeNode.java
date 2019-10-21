package foundation.tree.segmentTree;

public class SegmentTreeNode {

    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}
