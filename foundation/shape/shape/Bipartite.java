package foundation.shape.shape;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (int adjacent : graph[node]) {
                        if (colors[adjacent] == colors[node]) {
                            return false;
                        } else if (colors[adjacent] == 0) {
                            queue.offer(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                    }
                }
            }
        }
        return true;
    }
}
