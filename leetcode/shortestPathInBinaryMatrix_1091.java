package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortestPathInBinaryMatrix_1091 {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int res = 0;
        List<int[]> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int[] p : queue) {
                System.out.println("x=" + p[0] + " " + "y=" + p[1]);
            }
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                //System.out.println("x=" + p[0] + " " + "y=" + p[1]);
                if (p[0] == grid.length - 1 && p[1] == grid.length - 1) return res;
                for (int[] d : dir) {
                    int x = d[0] + p[0];
                    int y = d[1] + p[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 0 && !visited[x][y]) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int res = shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
