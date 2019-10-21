package foundation.stack;

public class StackIteration {

    public static int sum;

    /**
     * 单个递归
     * 都能用 while 循环重新写成迭代
     * @param num
     */
    public static void sumOfN(int num) {
        if (num == 0) {
            return;
        }
        sum += num;
        sumOfN(num - 1); //尾递归
    }

    public static int sumOfN2(int num) {
        if (num == 0) {
            return 0;
        }
        return num + sumOfN2(num - 1); //不是尾递归
    }

    public static int iteration(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num;
            num--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfN2(10));
        System.out.println(iteration(10));

    }
}
