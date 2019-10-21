package foundation.unionFind;

public interface IUnionFind {

    /**
     *有多少节点
     * @return
     */
    int count();

    /**
     *两个节点进行融合
     * @param x
     * @param y
     */
    void union(int x, int y);

    /**
     *找到对应的集合
     * @param index
     * @return
     */
    int find(int index);

    /**
     * 判断是否两个点是属于同一集合
     * @param x
     * @param y
     * @return
     */
    boolean connected(int x, int y);
}
