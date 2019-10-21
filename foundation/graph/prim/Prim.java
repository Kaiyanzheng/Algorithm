package foundation.graph.prim;

import foundation.queue.impl.ArrayOfQueueImpl;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {

    public void primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDists = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDists, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        /**
         * Pair: weight, Vertex
         */
        //PriorityQueue<Pair<Integer, Integer>>
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);
        Prim prim = new Prim();
        prim.primMST(graph);
    }
}
