package foundation.graph.skills;

import java.util.Arrays;

public class Hungary {

    int[] person;
    int[] places;

    public void match(int[][] matrix) {
        person = new int[4];
        places = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(places, -1);

        boolean[] visited;

        int res = 0; //几个最大匹配
        for (int i = 0; i < person.length; i++) {
            visited = new boolean[places.length];
            if (hungary(matrix, i, visited)) {
                res++;
            }
        }
        System.out.println("res : " + res);
        System.out.println(Arrays.toString(person));
        System.out.println(Arrays.toString(places));
    }

    /**
     *
     * @param matrix
     * @param start: 哪个人去匹配
     * @param visited
     * @return
     */
    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < places.length; end++) {
            //不能匹配到的条件：没有边 or 已经访问过
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }
            visited[end] = true;
            // 能匹配到的条件：没有占用 or 可以占位置
            if (places[end] == -1 || hungary(matrix, places[end], visited)) {
                person[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
        };
        Hungary hungary = new Hungary();
        hungary.match(matrix);
    }
}
