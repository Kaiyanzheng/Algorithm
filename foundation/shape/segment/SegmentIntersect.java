package foundation.shape.segment;


public class SegmentIntersect {

    /** returns true if line segment 'p1q1' and 'p2q2' intersect */
    public static boolean segmentIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if (o1 != o2 && o3 != o4) return true; // General case
        if (o1 == 0 && onSegment(p1, p2, q1)) return true; // p1, q1 and p2 collinear, p2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true; // p1, q1 and q2 collinear, q2 lies on segment p1q1
        if (o3 == 0 && onSegment(p2, p1, q2)) return true; // p2, q2 and p1 collinear, p1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true; // p2, q2 and q1 collinear, q1 lies on segment p2q2
        return false;
    }

    /** find orientation of orderd triplet (p, q, r) */
    public static int orientation(Point p, Point q, Point r) {
        int res = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (res == 0) return 0;  // collinear
        return res > 0 ? 1 : 2;  // 1: clockwise, 2: counterclockwise
    }

    /** check if point q lies on line segment pr */
    public static boolean onSegment (Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point q1 = new Point(10, 1);
        Point p2 = new Point(1, 2);
        Point q2 = new Point(10, 2);
        if (segmentIntersect(p1, q1, p2, q2)) System.out.println("Yes");
        else System.out.println("No");

        p1 = new Point(10, 1);
        q1 = new Point(0, 10);
        p2 = new Point(0, 0);
        q2 = new Point(10, 10);
        if (segmentIntersect(p1, q1, p2, q2)) System.out.println("Yes");
        else System.out.println("No");

        p1 = new Point(-5, -5);
        q1 = new Point(0, 0);
        p2 = new Point(1, 1);
        q2 = new Point(10, 10);;
        if (segmentIntersect(p1, q1, p2, q2)) System.out.println("Yes");
        else System.out.println("No");
    }
}
