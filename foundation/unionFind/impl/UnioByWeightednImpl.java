package foundation.unionFind.impl;

import foundation.unionFind.IUnionFind;

public class UnioByWeightednImpl implements IUnionFind {

    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] parents;

    /**
     * 权重
     */
    private int[] size;

    public UnioByWeightednImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.size = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
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
        if (size[xRoot] < size[yRoot]) {
            parents[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parents[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
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
            index = parents[index];
        }
        return index;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
