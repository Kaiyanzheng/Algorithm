package foundation.javaFoundation;

public class flowControl {

    public static void main(String[] args) {
        int a = 3;

        if (a == 1) {
            System.out.println("1");
        } else if (a == 2) {
            System.out.println("2");
        } else {
            System.out.println("--");
        }

        System.out.println(a == 1 ? "true" : "false");

        switch (a) {
            case 1 :
                System.out.println(1);
                break;
            case 2 :
                System.out.println(2);
                break;
            default:
                System.out.println("--");
                break;
        }
        // break: 跳出当前循环
        // continue: 跳过当前循环
        System.out.println("while");
        int index = 5;
        while (index > 0) {
            System.out.println(index);
            index--;
        }
    }
}
