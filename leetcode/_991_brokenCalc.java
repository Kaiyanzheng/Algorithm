package leetcode;

public class _991_brokenCalc {

    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            count++;
        }
        return count + X - Y;
    }

}
