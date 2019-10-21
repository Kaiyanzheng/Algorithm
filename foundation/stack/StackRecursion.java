package foundation.stack;

public class StackRecursion {

    public static void test() {
        test1();
    }

    public static void test1() {
        System.out.println("这是第一个调用");
        test2();
        System.out.println("这是第一个调用结束");
    }

    public static void test2() {
        System.out.println("这是第二个调用");
        test3();
        System.out.println("这是第二个调用结束");
    }

    public static void test3() {
        System.out.println("这是第三个调用");
        System.out.println("这是第三个调用结束");  //出栈
    }

    public static void main(String[] args) {
        test();
    }
}
