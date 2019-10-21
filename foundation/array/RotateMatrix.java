package foundation.array;

import java.util.Arrays;

public class RotateMatrix {

    /**
     * 按主对角线翻转, 按1,5,9翻转，只翻转一半，从左下角翻转至右上角
     * TIME: m*n
     *    j
     * [
     *  [1,2,3], i = 0
     *  [4,5,6], i = 1
     *  [7,8,9], i = 2
     *          ]
     * @param matrix
     */
    public static void diagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);
    }

    /**
     * 按副对角线翻转, 按3,5,7翻转，只翻转一半，从左上角翻转至右下角
     * @param matrix
     */
    public static void counterDiagonal (int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
        }
        print(matrix);
    }

    /**
     * 按中间一行对称翻转
     * @param matrix
     */
    public static void horizontal(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
        print(matrix);
    }

    public static void vertical(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        vertical(matrix);
    }
}
