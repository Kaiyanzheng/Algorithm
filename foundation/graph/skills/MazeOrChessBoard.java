package foundation.graph.skills;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeOrChessBoard {

    private int hasPath (int[][] maze, int[] start, int[] end) {

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, ...};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        int res = 0; // 最短距离

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            res++; // 1的个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (cur.x == end[0] && cur.y == end[1]) {
                    return res - 1;
                }
                for (int[] direction : directions) {
                    int newX = cur.x + direction[0];
                    int newY = cur.y + direction[1];
                    if (isValid(maze, newX, newY) && !visited[newX][newY]) {
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }

        }

        for (boolean[] visit : visited) {
            System.out.println(Arrays.toString(visit));
        }

        return -1;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        MazeOrChessBoard mazeOrChessBoard = new MazeOrChessBoard();
        System.out.println(mazeOrChessBoard.hasPath(maze, new int[]{0, 0}, new int[]{4, 4}));
    }
}
