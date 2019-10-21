package foundation.javaFoundation.ObjectOriented;

public class Main {

    public static void main(String[] agrs) {


        // 多态

        //向上转型

        SingleDog coder = new Coder();
        SingleDog teacher = new Teacher();

        coder.play();
        coder.work();


        //向下转型

        Coder coder2 = (Coder) coder;
        coder2.cs();

        if (coder instanceof Coder) {

        }

        if (coder instanceof Teacher) {

        }

    }
}
