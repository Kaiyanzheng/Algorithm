package foundation.unionFind.impl;

import foundation.unionFind.IUnionFind;

public class PathCompressionImpl implements IUnionFind {

    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] parents;

    public PathCompressionImpl(int count) {
        this.count = count;
        parents = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        parents[xRoot] = yRoot;
    }

    /**
     * 找ROOT,然后根根节点融合
     * 根节点：index = parents[index]
     * @param index
     * @return
     */
    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
        }
        return index;
    }

    public int find2(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        if (index != parents[index]){
            parents[index] = find(parents[index]);
        }
        return parents[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
