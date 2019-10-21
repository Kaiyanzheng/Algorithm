package foundation.stack;

public class StackLevel {

    /**
     * StackOverflowError
     */

    public static int level = 1;

    public static void level() {
        level++;
        level();
    }

    public static void main(String[] args) {
        try{
            level();
        } catch (StackOverflowError e) {
            System.out.println(level);
        }
    }

    /**
     * 尾递归
     * 每一层完全隔离
     * @param num
     * @return
     */
    public static int f(int num) {
        if (num == 1) {
            return 1;
        }
        return f(num - 1);
    }

    public static int f2(int num) {
        if (num == 1) {
            return 1;
        }
        return 1+ f(num - 1);
    }

}
