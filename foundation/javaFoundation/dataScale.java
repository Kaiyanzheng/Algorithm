package foundation.javaFoundation;

public class dataScale {
    //data Scale of JAVA: 10^8
    public static void dataScale() {
        for (int i = 1; i < 9; i++) { // cannot run if i < 10

            double num = Math.pow((double)i, 10); // num = 10 100 1000
            int sum = 0;

            long before = System.currentTimeMillis();
            for (int j = 0; j <= num; j++) {
                sum += j;
            }
            long end = System.currentTimeMillis();

            long per = end - before;
            System.out.println("10^" + i + ": " + per);

        }
    }

    public static void main(String[] args) {
        dataScale();
    }
}
