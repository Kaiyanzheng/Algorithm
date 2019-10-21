package jobPrep2019.ibm;

import java.util.Arrays;

public class meanderingArray {
    /** meandering order
     * [first_largest, first_smallest, second_largest, second_smallest]
     * [-1, 1, 2, 3, -5] normally -> [-5, -1, 1, 2, 3] -> [3, -5, 2, -1, 1]
     *
     */
    public int[] meanderingArray(int[] array) {
        if (array == null || array.length == 0) return array;
        Arrays.sort(array);
        int[] res = new int[array.length];
        int large = res.length - 1;
        int small = 0;
        int i = 0;
        while (small < large &&  i < array.length) {
            res[i++] = array[large--];
            res[i++] = array[small++];
        }
        if (array.length % 2 == 1) res[i++] = array[array.length / 2];
        return res;
    }

    public static void main(String[] args) {
        meanderingArray sol = new meanderingArray();
        int[] array = new int[]{-1, 1, 2, 3, -5};
        int[] res = sol.meanderingArray(array);
        for (int num : res) System.out.println(num);
    }
}
