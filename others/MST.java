package jobPrep2019.amazon.eight;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    public int MST(int numCities, int numRoads, List<List<Integer>> oldRoads,
                   List<List<Integer>> newRoads) {
        if (newRoads == null || newRoads.size() == 0) {
            return 0;
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(11, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                return l1.get(2) - l2.get(2);
            }
        });
        for (List<Integer> l : newRoads) {
            pq.add(l);
        }

        DSU uf = new DSU(numCities);
        HashSet<String> set = new HashSet<>();
        for (List<Integer> r : newRoads) {
            set.add(r.get(0) + "," + r.get(1));
        }

        int count = 0;
        for (List<Integer> r : oldRoads) {
            String key = r.get(0) + "," + r.get(1);
            if (set.contains(key)) {
                continue;
            }
            int index1 = r.get(0);
            int index2 = r.get(1);
            if (uf.union(index1, index2)) {
                count++;
            }
        }
        if (count >= numCities - 1) {
            return 0;
        }

        int sum = 0;
        while (!pq.isEmpty() && count < numCities - 1) {
            List<Integer> cur = pq.poll();
            int city1 = cur.get(0);
            int city2 = cur.get(1);
            if (uf.union(city1, city2)) {
                count++;
                sum += cur.get(2);
            }
        }
        if (count < numCities - 1) {
            return -1;
        }
        return sum;
    }

    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int size) {
            parent = new int[size + 1];
            for (int i = 0; i <= size; i++) {
                parent[i] = i;
            }
            rank = new int[size + 1];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (xr == yr) {
                return false;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else {
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }

    }
}
