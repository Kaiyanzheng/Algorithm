package foundation.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {

    /**
     * 1. GraphNode
     */

    // 不连通图
    public static void dfs(List<GraphNode> list) {
        HashSet<GraphNode> visited = new HashSet<>();
        for (GraphNode node : list) {
            if (!visited.contains(node)) {
                helper(node, visited);
            }
        }
    }

    /**
     * 连通图, 递归
     * 面试时通常写这个
     * @param node
     */
    public static void dfs2(GraphNode node) {
        helper(node, new HashSet<>());
    }

    public static void helper(GraphNode node, HashSet<GraphNode> visited) {
        visited.add(node);
        System.out.println(node.label);
        for (GraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited);
            }
        }
    }

    /**
     * 连通图，迭代
     * @param graphNode
     */
    public static void dfsIteration(GraphNode graphNode) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(graphNode);
        visited.add(graphNode);
        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            System.out.println(node.label);
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }


    /**
     * 2. Matrix
     * @param matrix
     */

    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                helper(matrix, visited, i);
            }
        }
    }

    public static void helper(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1) {
                if (visited[i] == 0) {
                    helper(matrix, visited, i);
                }
            }
        }
    }

    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    System.out.println(vertex);
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                stack.push(j);
                                visited[j] = 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b);
        a.neighbors.add(d);
        a.neighbors.add(f);

        b.neighbors.add(a);
        b.neighbors.add(e);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(d);
        e.neighbors.add(b);
        e.neighbors.add(c);

        f.neighbors.add(a);

        //dfs2(a);

        //dfsIteration(a);

        int[][] matrix = new int[][] {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0}
        };

        //dfsMatrix(matrix);
        dfsMatrixIteration(matrix);
    }


}
