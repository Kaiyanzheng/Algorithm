package foundation.shape.shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Square {

    /**
     * 平行于 X 轴
     * @param list
     * @return
     */
    public int countSquare(List<Point> list) {
        if (list.size() == 0) {
            return 0;
        }
        int res = 0;
        HashSet<Point> set = new HashSet<>();
        for (Point point : list) {
            set.add(point);
        }
        HashSet<String> dup = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point node2 = list.get(j);
                if (Math.abs(node1.x - node2.x) != Math.abs(node1.y - node2.y) //长方形去掉这行
                        || (node1.x == node2.x && node1.y == node2.y)) {
                    continue;
                }
                Point left = new Point(node1.x, node2.y);
                Point right = new Point(node2.x, node1.y);
                if (set.contains(left) && set.contains(right)) {
                    long dis = (left.x - right.x) * (left.x - right.x) + (left.y - right.y) * (left.y - right.y);
                    double centerX = (double)(left.x + right.x) / 2;
                    double centerY = (double)(left.y + right.y) / 2;
                    String info = "" + dis + "+" + centerX + "+" + centerY;
                    if (!dup.contains(info)) {
                        dup.add(info);
                        res++;
                    }

                }
            }
        }
        return res;
    }

    /**
     * 不平行于X轴
     * @param list
     * @return
     */
    public int countSquare2(List<Point> list) {
        if (list.size() == 0) {
            return 0;
        }
        int res = 0;
        HashMap<String, List<Point[]>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point node2 = list.get(j);
                long dis = (node1.x - node2.x) * (node1.x - node2.x) + (node1.y - node2.y) * (node1.y - node2.y);
                double centerX = (double)(node1.x + node2.x) / 2;
                double centerY = (double)(node1.y + node2.y) / 2;
                String info = "" + dis + "+" + centerX + "+" + centerY;
                map.computeIfAbsent(info, k -> new ArrayList<>());
                map.get(info).add(new Point[]{node1, node2}); // 如果info没有的话就加一个新的Point
                map.get(info).add(new Point[]{node1, node2});
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                List<Point[]> square = map.get(key);
                for (int i = 0; i < square.size(); i++) {
                    for (int j = i + 1; j < square.size(); j++) {
                        Point node1 = square.get(i)[0];
                        Point node2 = square.get(j)[0];
                        Point node3 = square.get(j)[1];
                        long len1 = (node1.x - node2.x) * (node1.x - node2.x) + (node1.y - node2.y) * (node1.y - node2.y);
                        long len2 = (node1.x - node3.x) * (node1.x - node3.x) + (node1.y - node3.y) * (node1.y - node3.y);
                        if (len1 == len2) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

}

