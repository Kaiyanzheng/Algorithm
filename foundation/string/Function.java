package foundation.string;

public class Function {

    public static void function() {
        String s1 = "abc";
        String s2 = "abc";
        //比较内容，对
        System.out.println(s1.equals(s2));
        // 比较的是内存的地址，引用
        //System.out.println(s1 == s2);
        String s = "banana";
        System.out.println(s.substring(1));
        System.out.println(s.substring(1, 3));//左闭右开
        System.out.println(s.indexOf("na"));
        System.out.println(s.indexOf("x"));
        System.out.println(s.lastIndexOf("an"));//从后往前找
        System.out.println(s.startsWith("ba"));
        char[] chars = s.toCharArray();
        System.out.println(chars);
        for (char ch : s.toCharArray());
        for (char ch : chars);
        for (int i = 0; i < s.length(); i++) {
            s.charAt(i);
        }
        String[] strings = s.split("n");
        for (String ss : strings){
            System.out.println(ss);
        }

        String sss = "  banana  ";
        System.out.println(sss.trim());

        char c = '9';
        System.out.println(Character.isDigit(c));
        char c2 = 'a';
        System.out.println(Character.isLetter(c2));
        System.out.println(Character.isLetterOrDigit(c2));
        System.out.println(Character.toUpperCase(c2));

        int num = 11;
        System.out.println(String.valueOf(num));

        String s3 = "11";
        System.out.println(Integer.parseInt(s3));

        String s5 = "a\\b\\c";
        System.out.println(s5);

    }

    public static void main(String[] args) {
        function();
    }
}
