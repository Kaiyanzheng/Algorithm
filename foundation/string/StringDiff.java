package foundation.string;

public class StringDiff {

    private static int time = 100000;

    public static void testString() {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            s += "1";
        }
        long end = System.currentTimeMillis();
        System.out.println(s.getClass().getName() + " TIME " + (end - start) + "ms");
    }

    public static void testStringBuffer() {
        StringBuffer s = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            s.append("1");
        }
        long end = System.currentTimeMillis();
        System.out.println(s.getClass().getName() + " TIME " + (end - start) + "ms");
    }

    public static void testStringBuilder() {
        StringBuilder s = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            s.append("1");
        }
        long end = System.currentTimeMillis();
        System.out.println(s.getClass().getName() + " TIME " + (end - start) + "ms");
    }

    public static void main(String[] args) {
        testString();
        testStringBuffer();
        testStringBuilder();
    }
}
