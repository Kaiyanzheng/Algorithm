package foundation.javaFoundation.exceptionImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {


        /**
         * Unchecked Exception = Runtime Exception
         */
        // NullPointerException空指针异常
        //String s = null;
        //System.out.println(s.length());

        //ArrayIndexOutOfBoundsException数组越界
        //String s = "abc";
        //System.out.println(s.charAt(5));

        /**
         * Checked Exception
         */
        //IO异常

        public static void test1() {
            Scanner scanner = new Scanner(System.in);
            try{
                System.out.println("输入第一个数字");
                int firstNumber = scanner.nextInt();
                System.out.println("输入第二个数字");
                int secondNumber = scanner.nextInt();
                System.out.println("最后除法的结果： " + firstNumber / secondNumber);
            } catch (InputMismatchException e) {
                System.out.println("输入不合法");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("发现错误");
                e.printStackTrace();
            } finally {
                System.out.println("程序结束");
            }

        }

        public static void test2() throws Exception{
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入第一个数字");
            int firstNumber = scanner.nextInt();
            System.out.println("输入第二个数字");
            int secondNumber = scanner.nextInt();
            System.out.println("最后除法的结果： " + firstNumber / secondNumber);
        }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个数字");
        int firstNumber = scanner.nextInt();
        //// most important!
        if (firstNumber > 100) {
            throw new IllegalArgumentException("超出100");
        }
        System.out.println("输入第二个数字");
        int secondNumber = scanner.nextInt();
        System.out.println("最后除法的结果： " + firstNumber / secondNumber);
    }

    public static void test4() throws MyException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个数字");
        int firstNumber = scanner.nextInt();
        if (firstNumber > 100) {
            throw new MyException();
        }
        System.out.println("输入第二个数字");
        int secondNumber = scanner.nextInt();
        System.out.println("最后除法的结果： " + firstNumber / secondNumber);
    }

        public static void main(String[] args) {
            //test1();

            // try {
            //     test2();
            // } catch (InputMismatchException e) {
            //     System.out.println("输入不合法");
            //     e.printStackTrace();
            // } catch (Exception e) {
            //     System.out.println("input 异常");
            //     e.printStackTrace();
            // }

            try {
                test4();
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

}

