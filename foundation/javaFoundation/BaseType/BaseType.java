package foundation.javaFoundation.BaseType;

public class BaseType {

    public static void baseType() {
        /**
         * initial : -128 ~ 127
         * int 没有 null 只有 0
         */
        int a = 130;
        int b = 130;
        Integer a1 = null;
        Integer x = 130;
        Integer y = 130;
        System.out.println(a == b);
        System.out.println(x == y);
        System.out.println(x.equals(y));

        /**
         * string -> int
         */
        String s = "123";
        int sint = Integer.parseInt(s);
        for (char c : s.toCharArray()) {
            int res = c - '0';
            System.out.println(res);
        }

        /**
         *  int -> string
         */
        String ss = x.toString();

        System.out.println((int) 'a');

        String sss = "abc";
        for (char c : sss.toCharArray()) {
            System.out.println(c - 'a'); //对应的ASCII码相减
        }

        int[] count = new int[256];

        for (char c : sss.toCharArray()) {
            count[c - 'a']++;
            System.out.println(c - 'a'); //每个字母多少次数
        }

    }

    public static void main(String[] args) {
        baseType();
    }
}
