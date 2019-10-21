package foundation.graph.shortestPath.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    public void dijkstra(Graph graph) {

        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        //PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
        //    @Override
        //    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        //        int key1 = o1.getKey();
        //        int key2 = o2.getKey();
        //        return key1 - key2;
        //    }
        //});

        minDist[0] = 0;
        //pq.offer(new Pair<>(minDist[0], 0));
    }
}
