package foundation.array;
import java.util.Arrays;

public class array {
    public static void array() {
        //int[] arr = new int[10];
        int[] array = new int[] {1,2,3};
        array[0] = 2;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {

        }

        for (int arr:array) {

        }

        int[][] array2 = new int[][] {
                {1,2,3},
                {1,2,3}
        };
        array2[1][2] = 3;

        int[] array3 = new int[3];
        System.out.println("array3: " + Arrays.toString(array3));



    }
    public static void main(String[] args) {
        array();
    }

}

