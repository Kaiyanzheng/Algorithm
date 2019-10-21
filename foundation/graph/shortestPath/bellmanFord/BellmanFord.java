package foundation.graph.shortestPath.bellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    public void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;


    }
}
