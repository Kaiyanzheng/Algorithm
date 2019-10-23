package leetcode;

import java.util.*;

public class slidingPuzzle {

    public List<List<String>> slidingPuzzle(int[][] board) {
        String end = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        helper(start, end, map);

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(start);
        getPath(map, start, end, res, list);
        return res;
    }

    private boolean helper(String start, String end, Map<String, List<String>> map) {
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                map.putIfAbsent(cur, new ArrayList<>());
                if (cur.equals(end)) return true;
                int zero = cur.indexOf('0');
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) continue;
                    map.get(cur).add(next);
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    private void getPath(Map<String, List<String>> map, String start, String end, List<List<String>> res, List<String> list) {
        if (start.equals(end)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(start)) return;
        for (String next : map.get(start)) {
            list.add(next);
            getPath(map, next, end, res, list);
            list.remove(list.size() - 1);
        }
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{4,1,2},{5,0,3}};
        slidingPuzzle sol = new slidingPuzzle();
        List<List<String>> res = sol.slidingPuzzle(board);
        for (List<String> l : res) {
            for (String p : l) {
                System.out.println(p.toCharArray());
            }
        }
    }
}
