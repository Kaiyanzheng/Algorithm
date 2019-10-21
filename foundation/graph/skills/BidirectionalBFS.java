package foundation.graph.skills;

import foundation.graph.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BidirectionalBFS {

    public int BidrectionalBFS(GraphNode start, GraphNode end) {

        Queue<GraphNode> startQueue = new LinkedList<>();
        HashSet<GraphNode> startVisited = new HashSet<>();
        startQueue.offer(start);
        startVisited.add(start);

        Queue<GraphNode> endQueue = new LinkedList<>();
        HashSet<GraphNode> endVisited = new HashSet<>();
        startQueue.offer(end);
        startVisited.add(end);

        int res = 0;

     //   while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
     //       int startSize = startQueue.size();
     //       res++;
     //       for (int i = 0; i < startSize; i++) {
     //           GraphNode node = startQueue.poll();
     //           for (GraphNode neighbor : node.neighbors) {
     //               if (endVisited.contains(neighbor)) {
     //                   return res;
     //               }
     //               if (!startVisited.contains(neighbor)) {
     //                   startVisited.add(neighbor);
     //                   startQueue.offer(neighbor);
     //               }
     //           }
     //       }
     //   }
        return -1;
    }
}
