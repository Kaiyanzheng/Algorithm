package jobPrep2019.amazon.eight;

import java.util.*;

public class MST2 {
    /**
     * 城市建路题。
     * 有一定数量的城市，城市之间已经有了一些道路。还有一些可以供选择的道路来建设。每个新建的道路有 cost。问如果要连接所有的城市，新建路的最小的 cost 是多少。
     * Input：
     * numTotalAvailableCities = 6
     * numTotalAvailableRoads = 3
     * roadsAvailable = [[1, 4], [4, 5], [2, 3]]
     * numNewRoadsConstruct = 4
     * costNewRoadsConstruct = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
     * Output 应该是： 7
     * 解释：numTotalAvailableCities = 6 意思是城市的编号从 1 到 6。基于提供的 roadsAvailable list, 这 6 个城市中 已经形成了三个岛， 分别为 [1, 4, 6], [2, 3] 和 [6]。 现在要从 costNewRoadsConstruct list 中选一些路来建使得所有的城市都被连接。这个例子中，显然要选择[1, 2, 5] 和 [1, 6, 2] 这两条路。总的 cost 就是 5 + 2 = 7。
     *
     * 解题思路：
     * 这是个最小生成树（MST）问题。但要注意整个图中已经有一些边了，不是从0开始的最小生成树。具体来说，可以先Union-Find所有已经有的路 in roadsAvailable list，然后把所有可以建的路 in costNewRoadsConstruct list 按照 cost 排序放入 min-heap。然后每次从 min-heap 中拿出最小 cost 的路来接着 Union-Find整个图。每次需要Union的时候，累积目前为止的 cost。当总的 edges 数目等于总的 vertices 数目减 1 时，整个图就被构建成了一颗树。这时输入累积的cost作为输出。
     * 注意：
     * 这个题不太容易过所有的 test case （目前有19个test cases），因为有些坑需要避免。
     * 1. 城市的ID是从1开始，不是从0开始。所以UnionFind的时候要多注意。
     * 2. 输入的roadsAvailable list 和 costNewRoadsConstruct list 互相之间可能有重复。所以不要在算Graph中的 edges 数目的时候要格外注意。
     */
    public int getMinimumCostToConstruct(int numTotalAvailableCities,
                                         int numTotalAvailableRoads,
                                         List<List<Integer>> roadsAvailable,
                                         int numNewRoadsConstruct,
                                         List<List<Integer>> costNewRoadsConstruct) {
        if (numTotalAvailableCities < 2 || numTotalAvailableRoads >= numTotalAvailableCities - 1) {
            return 0;
        }
        UnionFind uf = new UnionFind(numTotalAvailableCities);
        int roadCount = 0;
        for (List<Integer> road : roadsAvailable) {
            int city1 = road.get(0);
            int city2 = road.get(1);
            if (!uf.connected(city1, city2)) {
                uf.union(city1, city2);
                roadCount++;
            }
        }

        PriorityQueue<Construct> pq = new PriorityQueue<>(numNewRoadsConstruct, Comparator.comparingInt(a -> a.cost));

        for (List<Integer> road : costNewRoadsConstruct) {
            Construct construct = new Construct(road.get(0), road.get(1), road.get(2));
            pq.offer(construct);
        }

        List<Construct> list = new ArrayList<>();

        while (pq.size() > 0 && list.size() + roadCount < numTotalAvailableCities - 1) {
            Construct tmp = pq.poll();
            int city1 = tmp.city1;
            int city2 = tmp.city2;
            if (!uf.connected(city1, city2)) {
                uf.union(city1, city2);
                list.add(tmp);
            }
        }

        if (list.size() + roadCount < numTotalAvailableCities - 1) {
            return -1;
        }

        int res = 0;
        for (Construct construct : list) {
            res += construct.cost;
        }

        return res;
    }

    class UnionFind {

        private int[] id;

        public UnionFind (int size) {
            this.id = new int[size + 1];
            for (int i = 0; i < size + 1; i++) {
                this.id[i] = i;
            }
        }
        public int find (int index) {
            return id[index];
        }

        public boolean connected (int x, int y) {
            return find(x) == find(y);
        }

        public void union (int x, int y) {
            int A = find(x);
            int B = find(y);
            id[A] = B;
        }
    }

    class Construct {

        int city1;
        int city2;
        int cost;

        public Construct(int city1, int city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        MST2 sol = new MST2();
        int numTotalAvailableCities = 6;
        int numTotalAvailableRoads = 3;
        List<List<Integer>> roadsAvailable = new ArrayList<>();
        List<Integer> roadsAvailable1 = new ArrayList<>();
        roadsAvailable1.add(1);
        roadsAvailable1.add(4);
        List<Integer> roadsAvailable2 = new ArrayList<>();
        roadsAvailable2.add(4);
        roadsAvailable2.add(5);
        List<Integer> roadsAvailable3 = new ArrayList<>();
        roadsAvailable3.add(2);
        roadsAvailable3.add(3);
        roadsAvailable.add(roadsAvailable1);
        roadsAvailable.add(roadsAvailable2);
        roadsAvailable.add(roadsAvailable3);
        int numNewRoadsConstruct = 4;
        List<List<Integer>> costNewRoadsConstruct = new ArrayList<>();
        List<Integer> costNewRoadsConstruct1 = new ArrayList<>();
        costNewRoadsConstruct1.add(1);
        costNewRoadsConstruct1.add(2);
        costNewRoadsConstruct1.add(5);
        List<Integer> costNewRoadsConstruct2 = new ArrayList<>();
        costNewRoadsConstruct2.add(1);
        costNewRoadsConstruct2.add(3);
        costNewRoadsConstruct2.add(10);
        List<Integer> costNewRoadsConstruct3 = new ArrayList<>();
        costNewRoadsConstruct3.add(1);
        costNewRoadsConstruct3.add(6);
        costNewRoadsConstruct3.add(2);
        List<Integer> costNewRoadsConstruct4 = new ArrayList<>();
        costNewRoadsConstruct4.add(5);
        costNewRoadsConstruct4.add(6);
        costNewRoadsConstruct4.add(5);
        costNewRoadsConstruct.add(costNewRoadsConstruct1);
        costNewRoadsConstruct.add(costNewRoadsConstruct2);
        costNewRoadsConstruct.add(costNewRoadsConstruct3);
        costNewRoadsConstruct.add(costNewRoadsConstruct4);
        int res = sol.getMinimumCostToConstruct(numTotalAvailableCities, numTotalAvailableRoads, roadsAvailable, numNewRoadsConstruct, costNewRoadsConstruct);
        System.out.println(res);
    }

}
