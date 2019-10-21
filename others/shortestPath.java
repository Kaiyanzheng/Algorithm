package jobPrep2019.amazon.eight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortestPath {
    /**
     * Shortest path, Maze (2d array) (Robert / remove obstacle / Fresh delivery)
     * 机器人，0不能走，1能走，求走到9的最小步数
     * 从左上角出发，1是路， 9是destination， 求最短路径步数。简单图最短路径经典BFS
     * Given a 2D matrix, where each cell has value of 1, 0, or 9.
     * 1 indicates a flat area (can be reached to), 0 a trench(can't reach), 9 target.
     * Find the minimum distance starting from top left corner to target(9).
     * 2.2 输入一个List<List<Integer>>, 每个元素值是1, 0, 或者9. 1 代表可以走的路, 0 是不能走的, 9 是target。求从原点走到9 最短距离。
      	[[1, 0, 0],
         [1, 0, 0],
         [1, 9 ,0]].
      	 output: 3 [0, 0] -> [1, 0] -> [2, 0] -> [2, 1]
         time: O(mn)       */
    public int minDistance(int numR, int numC, int[][] area) {
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        boolean[][] visited = new boolean[numR][numC];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (area[cur[0]][cur[1]] == 9) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < numR && y >= 0 && y < numC && !visited[x][y] && area[x][y] != 0) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public int minDistance2(int numR, int numC, List<List<Integer>> area) {
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        boolean[][] visited = new boolean[numR][numC];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (area.get(cur[0]).get(cur[1]) == 9) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < numR && y >= 0 && y < numC && !visited[x][y] && area.get(x).get(y) != 0) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }


    public static void main(String[] args) {
        shortestPath sol = new shortestPath();
        //int[][] area = new int[][] {{1, 0, 0}, {1, 0, 0}, {1, 9, 0}};
        List<List<Integer>> area = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(0);
        a1.add(0);
        area.add(a1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(0);
        a2.add(0);
        area.add(a2);
        List<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(9);
        a3.add(0);
        area.add(a3);
        int res = sol.minDistance2(3, 3, area);
        System.out.println(res);
    }
}
