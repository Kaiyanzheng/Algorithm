package foundation.graph;

import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberofIsland {
    /**
     *  Flood Fill Algorithm
     */



    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    floodfill(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * DFS
     * @param grid
     * @param i
     * @param j
     */

    private void floodfill(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        floodfill(grid, i, j + 1);
        floodfill(grid, i, j - 1);
        floodfill(grid, i + 1, j);
        floodfill(grid, i - 1, j);
    }

    /**
     * BFS
     * time: O(k * m * n)  k: 1的个数, 最差情况 m * n
     * space: 具体分析
     * @param grid
     * @param x
     * @param y
     */
    private void floodfill2(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y); //二维转换成一维
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * n + j);
                grid[i - 1][j] = '0';
            }
            if (i < m - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * n + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * n + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < n - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * n + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    /**
     * BFS最终优化
     * time: O(k * m * n)  k: 1的个数, 最差情况 m * n
     * space: 具体分析
     *
     * @param grid
     * @param x
     * @param y
     */
    private void floodfill3(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] direction : directions) {
                int newX = cur.x + direction[0];
                int newY = cur.y + direction[1];
                if (isValid(grid, newX, newY)) {
                    queue.offer(new Point(newX, newY));
                    grid[newX][newY] = '0';
                }
            }
        }
    }

    private boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
